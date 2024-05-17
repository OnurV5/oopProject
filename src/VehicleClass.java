public class VehicleClass implements Vehicle {
    private int avgSpeed;
    private int avgFuelConsumption;
    private int avgRange;
    private int weightCapacity;

    public void setAvgSpeed(int avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public void setAvgFuelConsumption(int avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }

    public void setAvgRange(int avgRange) {
        this.avgRange = avgRange;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
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
    public VehicleClass()
    {}
}
