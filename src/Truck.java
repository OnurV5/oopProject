public class Truck implements Vehicle{
    int avgSpeed;
    int avgFuelConsumption;
    int avgRange;
    int weightCapacity;
    private Truck(int speed,int fuelConsumption,int range,int weightCapacity)
    {
        avgRange=range;
        avgSpeed=speed;
        avgFuelConsumption=fuelConsumption;
        this.weightCapacity=weightCapacity;
    }
    public static Vehicle getTruck(int speed, int fuelConsumption, int range, int weightCapacity)
    {
        return new Truck(speed,fuelConsumption,range,weightCapacity);
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
