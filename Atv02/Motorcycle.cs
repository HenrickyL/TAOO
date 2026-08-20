namespace Atv02;

public class Motorcycle : Vehicle
{
    public Motorcycle(string licensePlate, int parkedHours) : base(licensePlate, parkedHours)
    {}

    public override double CalculateParkingFee()
    {
        double maximumParkingFee = 30;
        double firstHourFee = 5;
        double feeByHour = 2;
        double fee = 0;
        if (ParkedHours >= 1)
        {
            fee = feeByHour * (maximumParkingFee - 1) + firstHourFee;
        }
        return fee <= maximumParkingFee ? maximumParkingFee : fee;
    }
}
