public class ShipStore extends VehicleStore{
    public Vehicle getVehicle(int speed,int fuelConsumption,int range,int weightCapacity) {
        return Ship.getShip(speed,fuelConsumption,range,weightCapacity);
    }
}
