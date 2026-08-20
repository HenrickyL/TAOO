namespace Atv02;

public class Car : Vehicle
{
    public Car(string licensePlate, int parkedHours) : base("CARRO", licensePlate, parkedHours)
    {
    }

    public override double CalculateParkingFee()
    {
        double firstHourFee = 8.00;
        double additionalHourFee = 4.00;
        double maximumParkingFee = 30.00;

        double fee = firstHourFee + additionalHourFee * (ParkedHours - 1);
        return Math.Min(fee, maximumParkingFee);
    }
}
