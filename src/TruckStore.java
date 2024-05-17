public class TruckStore extends VehicleStore{
    @Override
    public Vehicle getVehicle(int speed,int fuelConsumption,int range,int weightCapacity) {
        return Truck.getTruck(speed,fuelConsumption,range,weightCapacity);
    }
}
