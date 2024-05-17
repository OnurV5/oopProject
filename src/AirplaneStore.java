public class AirplaneStore extends VehicleStore {
    public Airplane getVehicle(int speed, int fuelConsumptionper100KM, int range, int weightCapacity) {
        return Airplane.getAirplane(speed, fuelConsumptionper100KM, range, weightCapacity);
    }
}
