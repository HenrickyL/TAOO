using System.Text;

namespace Atv01;

public class OrderResult
{
    public double Subtotal { get; set; }
    public double Discount { get; set; }
    public List<Item> Items { get; set; }

    public override string ToString()
    {
        var sb = new StringBuilder();
        sb.AppendLine("PEDIDO");

        var itensValidos = Items;

        if (itensValidos.Count == 0)
        {
            sb.AppendLine("NENHUM ITEM VALIDO");
            sb.AppendLine("SUBTOTAL: 0.00");
            sb.AppendLine("DESCONTO: 0.00");
            sb.AppendLine("TOTAL: 0.00");
            return sb.ToString();
        }

        foreach (var item in itensValidos)
        {
            sb.AppendLine($"{item.ProductName} {item.Quantity} x {item.ProductPrice:F2} = {item.CalculateSubtotal():F2}");
        }

        double subtotalPedido = itensValidos.Sum(i => i.CalculateSubtotal());
        double total = subtotalPedido - Discount;

        sb.AppendLine($"SUBTOTAL: {subtotalPedido:F2}");
        sb.AppendLine($"DESCONTO: {Discount:F2}");
        sb.AppendLine($"TOTAL: {total:F2}");

        return sb.ToString();

    }
}

public class Order {
    private List<Item> items = new();

    public void Add(Product product, int quantity=1) {
        Item? item = items.FirstOrDefault(x => x.ProductCode == product.Code);
        if (item == null)
        {
            this.items.Add(new Item { Product = product, Quantity = quantity });
        }
        else {
            item.IncreaseQuantity(quantity);
        }
    }

    private double CalculateSubtotal()
    {
        double subtotal = 0;
        foreach (var item in items) {
            subtotal += item.CalculateSubtotal();
        }
        return subtotal;
    }

    private double CalculateDiscount(double value)
    {
        double discount = 0;
        double subtotal = value;
        if (subtotal > 100f) {
            discount = 0.1;
        }
        return discount;
    }
    public OrderResult CalculateTotal()
    {
        double subtotal = this.CalculateSubtotal();
        double discount = this.CalculateDiscount(subtotal);

        return new OrderResult { 
            Subtotal=subtotal,
            Discount=discount,
            Items = this.items
        };
    }
}
