namespace Atv02;

public abstract class Vehicle
{
    public string LicensePlate { get; private set; }
    public int ParkedHours { get; set; }
    public string TypeName {get; private set;}

    public Vehicle(string TypeName, string licensePlate, int parkedHours)
    {
        this.TypeName = TypeName;
        this.LicensePlate = licensePlate;
        this.ParkedHours = parkedHours;
    }

    public abstract double CalculateParkingFee();
}