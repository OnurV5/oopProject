public class Ship extends VehicleClass implements Vehicle {

    private Ship(int speed, int fuelConsumption, int range, int weightCapacity,int ID)
    {
        setAvgRange(range);
        setAvgSpeed(speed);
        setAvgFuelConsumption(fuelConsumption);
        setWeightCapacity(weightCapacity);
        setID(ID);
    }
    public static Ship getShip(int speed, int fuelConsumption, int range, int weightCapacity,int ID)
    {
        return new Ship(speed,fuelConsumption,range,weightCapacity,ID);
    }

}
