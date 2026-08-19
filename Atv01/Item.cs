namespace Atv01;
public class Item
{
    public Product Product { private get; set; }
    public int Quantity { get; set; } = 1;

    public int ProductCode => Product.Code;
    public String ProductName => Product.Name;
    public double ProductPrice => Product.Price;


    public double CalculateSubtotal()
    {
        return Product.Price * Quantity;
    }
    public void IncreaseQuantity(int amount = 1)
    {
        Quantity += amount;
    }
}
