public class AirplaneStore extends VehicleStore {
    public Vehicle getVehicle(int speed, int fuelConsumption, int range, int weightCapacity) {
        return Airplane.getAirplane(speed, fuelConsumption, range, weightCapacity);
    }
}
