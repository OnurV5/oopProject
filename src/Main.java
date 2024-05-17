import java.util.ArrayList;

public class Main {
    public static TruckStore truckStore=new TruckStore();
    static ArrayList<Truck> Trucks=new ArrayList<Truck>();
    public static ShipStore shipStore=new ShipStore();
    static ArrayList<Ship> Ships=new ArrayList<Ship>();
    public static AirplaneStore airplaneStore=new AirplaneStore();
    static ArrayList<Airplane> Airplanes=new ArrayList<Airplane>();

    /*
    DEFAULT VEHİCLES:

    1623xTruck
    104xShips
    1xAirplane
    */
    static public void initialize()
    {
        for(int i=0;i<1623;i++)
        {
            Truck a=truckStore.getVehicle(85,35,1000,23500);
            Trucks.add(a);
        }
        for(int i=0;i<104;i++)
        {
            Ship a=shipStore.getVehicle(41,13540,1000,650000);
            Ships.add(a);
        }
        Airplane a=airplaneStore.getVehicle(930,330,1000,58000);
        Airplanes.add(a);
    }
    public static void main(String[] Args)
    {
        initialize();

    }
}
