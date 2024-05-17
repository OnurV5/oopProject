public class Ship implements Vehicle {

    int avgSpeed;
    int avgFuelConsumption;
    int avgRange;
    int weightCapacity;
    private Ship(int speed,int fuelConsumption,int range,int weightCapacity)
    {
        avgRange=range;
        avgSpeed=speed;
        avgFuelConsumption=fuelConsumption;
        this.weightCapacity=weightCapacity;
    }
    public static Ship getShip(int speed, int fuelConsumption, int range, int weightCapacity)
    {
        return new Ship(speed,fuelConsumption,range,weightCapacity);
    }

    @Override
    public int getSpeed() {
        return avgSpeed;
    }

    @Override
    public int getFuelConsumption() {
        return avgFuelConsumption;
    }

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public int getRange() {
        return avgRange;
    }
}
