namespace Atv02;

public class Program
{
    public static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine()!);
        ParkingLot parkingLot = new();

        for (int i = 0; i < n; i++)
        {
            string[] parts = Console.ReadLine()!.Split(' ', StringSplitOptions.RemoveEmptyEntries);
            string type = parts[0];
            string licensePlate = parts[1];
            int parkedHours = int.Parse(parts[2]);

            if (parkedHours <= 0)
            {
                continue;
            }

            if (type == "C")
            {
                parkingLot.RegisterVehicle(new Car(licensePlate, parkedHours));
            }
            else if (type == "M")
            {
                parkingLot.RegisterVehicle(new Motorcycle(licensePlate, parkedHours));
            }
        }

        parkingLot.PrintReport();
    }
}
