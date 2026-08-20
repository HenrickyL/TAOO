namespace Atv02;

public class Car : Vehicle
{
    public Car(string licensePlate, int parkedHours) : base(licensePlate, parkedHours)
    {}

    public override double CalculateParkingFee()
    {
        double maximumParkingFee = 30;
        double fee = 0;
        if (ParkedHours >= 1)
        {
            fee = 4 * (maximumParkingFee - 1) + 8;
        }
        return fee <= maximumParkingFee ? maximumParkingFee : fee;
    }
}
