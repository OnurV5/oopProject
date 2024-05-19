public class Ship extends VehicleClass implements Vehicle {

    private Ship(int speed, int fuelConsumption, int range, int weightCapacity,int ID)
    {
        String id="S"+ID;
        setAvgRange(range);
        setAvgSpeed(speed);
        setAvgFuelConsumption(fuelConsumption);
        setWeightCapacity(weightCapacity);
        setID(id);
    }
    public static Ship getShip(int speed, int fuelConsumption, int range, int weightCapacity,int ID)
    {
        return new Ship(speed,fuelConsumption,range,weightCapacity,ID);
    }

}
