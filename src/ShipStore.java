public class ShipStore extends VehicleStore{
    public Ship getVehicle(int speed,int fuelConsumptionper100Km,int range,int weightCapacity) {
        return Ship.getShip(speed,fuelConsumptionper100Km,range,weightCapacity);
    }
}
