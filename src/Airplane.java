public class Airplane extends VehicleClass implements Vehicle{
    private Airplane(int speed, int fuelConsumption, int range, int weightCapacity)
    {
        setAvgRange(range);
        setAvgSpeed(speed);
        setAvgFuelConsumption(fuelConsumption);
        setWeightCapacity(weightCapacity);
    }
    public static Airplane getAirplane(int speed, int fuelConsumption, int range, int weightCapacity)
    {
        return new Airplane(speed,fuelConsumption,range,weightCapacity);
    }

}
