namespace Atv02;

public class Motorcycle : Vehicle
{
    public Motorcycle(string licensePlate, int parkedHours) : base("MOTO", licensePlate, parkedHours)
    {
    }


    public override double CalculateParkingFee()
    {
        double firstHourFee = 5.00;
        double additionalHourFee = 2.00;
        double maximumParkingFee = 18.00;

        double fee = firstHourFee + additionalHourFee * (ParkedHours - 1);
        return Math.Min(fee, maximumParkingFee);
    }
}
