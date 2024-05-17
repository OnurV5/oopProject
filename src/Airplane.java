public class Airplane implements Vehicle{
    int avgSpeed;
    int avgFuelConsumption;
    int avgRange;
    int weightCapacity;
    private Airplane(int speed,int fuelConsumption,int range,int weightCapacity)
    {
        avgRange=range;
        avgSpeed=speed;
        avgFuelConsumption=fuelConsumption;
        this.weightCapacity=weightCapacity;
    }
    public static Vehicle getAirplane(int speed, int fuelConsumption, int range, int weightCapacity)
    {
        return new Airplane(speed,fuelConsumption,range,weightCapacity);
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
