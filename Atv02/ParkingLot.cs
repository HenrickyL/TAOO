
namespace Atv02;

public class ParkingLot
{
    private List<Vehicle> vehicles = new();



    public void RegisterVehicle(Vehicle vehicle)
    {
        vehicles.Add(vehicle);
    }

    public double CalculateTotalFee() {
        double totalFee = 0;
        foreach (Vehicle vehicle in vehicles) { 
            totalFee += vehicle.CalculateParkingFee();
        }
        return totalFee;
    }

    public void ListVehicles()
    {
        foreach (var vehicle in vehicles)
        {
            Console.WriteLine($"License Plate: {vehicle.LicensePlate}, Parked Hours: {vehicle.ParkedHours}, Parking Fee: {vehicle.CalculateParkingFee()}");
        }
    }

}
