namespace Atv02;

public abstract class Vehicle
{
    public string LicensePlate { get; set; }
    public int ParkedHours { get; set; }

    public Vehicle(string licensePlate, int parkedHours)
    {
        this.LicensePlate = licensePlate;
        this.ParkedHours = parkedHours;
    }

    public abstract double CalculateParkingFee();
}