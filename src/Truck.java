public class Truck extends VehicleClass implements Vehicle{

    private Truck(int speed, int fuelConsumption, int range, int weightCapacity)
    {
        setAvgRange(range);
        setAvgSpeed(speed);
        setAvgFuelConsumption(fuelConsumption);
        setWeightCapacity(weightCapacity);
    }
    public static Truck getTruck(int speed, int fuelConsumption, int range, int weightCapacity)
    {
        return new Truck(speed,fuelConsumption,range,weightCapacity);
    }


}
