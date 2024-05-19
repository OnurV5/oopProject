public class Airplane extends VehicleClass implements Vehicle{
    private Airplane(int speed, int fuelConsumption, int range, int weightCapacity,int ID)
    {
        String id="A"+ID;
        setAvgRange(range);
        setAvgSpeed(speed);
        setAvgFuelConsumption(fuelConsumption);
        setWeightCapacity(weightCapacity);
        setID(id);
    }
    public static Airplane getAirplane(int speed, int fuelConsumption, int range, int weightCapacity,int ID)
    {
        return new Airplane(speed,fuelConsumption,range,weightCapacity,ID);
    }

}
