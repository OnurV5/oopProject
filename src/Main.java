import java.util.ArrayList;

public class Main {
    public static TruckStore truckStore=new TruckStore();
    static ArrayList<VehicleClass> Trucks=new ArrayList<VehicleClass>();
    public static ShipStore shipStore=new ShipStore();
    static ArrayList<VehicleClass> Ships=new ArrayList<VehicleClass>();
    public static AirplaneStore airplaneStore=new AirplaneStore();
    static ArrayList<VehicleClass> Airplanes=new ArrayList<VehicleClass>();

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
            VehicleClass a=truckStore.getVehicle(85,35,1000,23500);
            Trucks.add(a);
        }
        for(int i=0;i<104;i++)
        {
            VehicleClass a=shipStore.getVehicle(41,13540,1000,650000);
            Ships.add(a);
        }
        VehicleClass a=airplaneStore.getVehicle(930,330,1000,58000);
        Airplanes.add(a);
    }
    public static void writeVehicleListAsJSON(ArrayList<VehicleClass> list)
    {

        while(!list.isEmpty())
        {
            System.out.println(list.get(0).getSpeed());
            list.remove(0);
        }
    }
    public static void main(String[] Args)
    {
        initialize();
        writeVehicleListAsJSON(Airplanes);

    }
}
