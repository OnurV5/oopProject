public class Truck extends VehicleClass implements Vehicle{

    private Truck(int speed, int fuelConsumption, int range, int weightCapacity,int ID)
    {
        setAvgRange(range);
        setAvgSpeed(speed);
        setAvgFuelConsumption(fuelConsumption);
        setWeightCapacity(weightCapacity);
        setID(ID);
    }
    public static Truck getTruck(int speed, int fuelConsumption, int range, int weightCapacity,int ID)
    {
        return new Truck(speed,fuelConsumption,range,weightCapacity,ID);
    }


}
