public class TruckStore extends VehicleStore{
    @Override
    public Truck getVehicle(int speed,int fuelConsumptionper100KM,int range,int weightCapacity,int ID) {
        return Truck.getTruck(speed,fuelConsumptionper100KM,range,weightCapacity,ID);
    }
}
