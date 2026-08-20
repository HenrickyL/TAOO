using System.Globalization;

namespace Atv02;

public class ParkingLot
{
    private readonly List<Vehicle> vehicles = new();

    public void RegisterVehicle(Vehicle vehicle)
    {
        vehicles.Add(vehicle);
    }

    public double CalculateTotalFee()
    {
        double totalFee = 0;
        foreach (Vehicle vehicle in vehicles)
        {
            totalFee += vehicle.CalculateParkingFee();
        }
        return totalFee;
    }

    public int GetValidVehicleCount()
    {
        return vehicles.Count;
    }

    public void PrintReport()
    {
        Console.WriteLine("ESTACIONAMENTO");

        if (vehicles.Count == 0)
        {
            Console.WriteLine("NENHUM VEICULO VALIDO");
        }
        else
        {
            foreach (Vehicle vehicle in vehicles)
            {
                string fee = vehicle.CalculateParkingFee().ToString("F2", CultureInfo.InvariantCulture);
                Console.WriteLine($"{vehicle.LicensePlate} - {vehicle.TypeName} - {vehicle.ParkedHours} h - R$ {fee}");
            }
        }

        string total = CalculateTotalFee().ToString("F2", CultureInfo.InvariantCulture);
        Console.WriteLine($"VEICULOS: {GetValidVehicleCount()}");
        Console.WriteLine($"TOTAL: R$ {total}");
    }
}
