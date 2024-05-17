public class Ship extends VehicleClass implements Vehicle {

    private Ship(int speed, int fuelConsumption, int range, int weightCapacity)
    {
        setAvgRange(range);
        setAvgSpeed(speed);
        setAvgFuelConsumption(fuelConsumption);
        setWeightCapacity(weightCapacity);
    }
    public static Ship getShip(int speed, int fuelConsumption, int range, int weightCapacity)
    {
        return new Ship(speed,fuelConsumption,range,weightCapacity);
    }

}
