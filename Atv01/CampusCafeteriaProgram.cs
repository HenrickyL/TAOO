namespace Atv01;
public class CampusCafeteriaProgram{
    private readonly List<Product> products = new();
    private Order currentOrder;
    public CampusCafeteriaProgram()
    {
        products.Add(new Product { Code = 1, Name = "X-Salada", Price = 20.0 });
        products.Add(new Product { Code = 2, Name = "Suco", Price = 7.5 });
        products.Add(new Product { Code = 3, Name = "Batata Frita", Price = 12.0 });
        products.Add(new Product { Code = 4, Name = "Café", Price = 5.0 });
        products.Add(new Product { Code = 5, Name = "Pudim", Price = 10.0 });
    }

    private void ReadOrder() {
        Order order = new Order();
        int N = int.Parse(Console.ReadLine());

        int[] codigos = new int[N];
        int[] quantidades = new int[N];

        for (int i = 0; i < N; i++)
        {
            string[] entrada = Console.ReadLine().Split(' ');
            codigos[i] = int.Parse(entrada[0]);
            quantidades[i] = int.Parse(entrada[1]);
            Product? product = products.FirstOrDefault(p => p.Code == codigos[i]);
            if (product != null)
            {
                order.Add(product, quantidades[i]);
            }
        }
        this.currentOrder = order;
    }

    public void Run()
    {
        ReadOrder();
        OrderResult result = currentOrder.CalculateTotal();
        Console.WriteLine(result.ToString());
    }
}