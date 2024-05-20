import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static TruckStore truckStore=new TruckStore();
    static ArrayList<VehicleClass> Trucks=new ArrayList<VehicleClass>();
    public static ShipStore shipStore=new ShipStore();
    static ArrayList<VehicleClass> Ships=new ArrayList<VehicleClass>();
    public static AirplaneStore airplaneStore=new AirplaneStore();
    static ArrayList<VehicleClass> Airplanes=new ArrayList<VehicleClass>();
    static ArrayList<Driver> Drivers = new ArrayList<>();
    public static ArrayList<Order> Orders = new ArrayList<>();
    /*
    DEFAULT VEHİCLES:

    1623xTruck
    104xShips
    1xAirplane
    */
    static public void initializeVehicles() throws FileNotFoundException {
        Trucks=readTruckListfromJSON("./TrucksInfo");
        Ships=readShipListfromJSON("./ShipsInfo");
        Airplanes=readAirplaneListfromJSON("./AirplanesInfo");
        Drivers=readDriverListfromJSON("./DriversInfo");
        Orders=readOrderListfromJSON("./OrdersInfo");
        System.out.println("Vehicles, Drivers and Orders are Initialized!");
    }
    public static void addDriver(ArrayList<Driver> Drivers, Driver driver) { Drivers.add(driver); }
    public static void deleteDriver(ArrayList<Driver> Drivers, int driverID) {
        Iterator<Driver> iterator = Drivers.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            if (driver.getDriverID() == driverID) {
                iterator.remove();
                return;
            }
        }
    }
    public static Driver driverOfVehicle(ArrayList<Driver> Drivers, String vehicleID) {
        for (Driver d : Drivers) {
            if (d.getVehicle().getID().equals(vehicleID))
                return d;
        }
        return null;
    }
    public static Driver searchDriver(ArrayList<Driver> Drivers, int driverID) {
        for (Driver driver : Drivers) {
            if (driver.getDriverID() == driverID)
                return driver;
        }
        return null;
    }
    public static void writeVehicleListtoJSON(ArrayList<VehicleClass> list,String filePath) throws IOException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        File file=new File(filePath);
        FileWriter fileWriter=new FileWriter(file);
        gson.toJson(list,fileWriter);
        fileWriter.close();
    }
    public static void writeDriverListtoJSON(ArrayList<Driver> list,String filePath) throws IOException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        File file=new File(filePath);
        FileWriter fileWriter=new FileWriter(file);
        gson.toJson(list,fileWriter);
        fileWriter.close();
    }
    public static void writeOrderListtoJSON(ArrayList<Order> list,String filePath) throws IOException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        File file=new File(filePath);
        FileWriter fileWriter=new FileWriter(file);
        gson.toJson(list,fileWriter);
        fileWriter.close();
    }
    public static ArrayList<Driver> readDriverListfromJSON(String filePath) throws FileNotFoundException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        File file=new File(filePath);
        FileReader fileReader=new FileReader(file);
        Type listType=new TypeToken<ArrayList<Driver>>(){}.getType();
        return gson.fromJson(fileReader,listType);
    }
    public static ArrayList<VehicleClass> readTruckListfromJSON(String filePath) throws FileNotFoundException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        File file=new File(filePath);
        FileReader fileReader=new FileReader(file);
        Type listType=new TypeToken<ArrayList<Truck>>(){}.getType();
        return gson.fromJson(fileReader,listType);
    }
    public static ArrayList<VehicleClass> readShipListfromJSON(String filePath) throws FileNotFoundException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        File file=new File(filePath);
        FileReader fileReader=new FileReader(file);
        Type listType=new TypeToken<ArrayList<Ship>>(){}.getType();
        return gson.fromJson(fileReader,listType);
    }
    public static ArrayList<VehicleClass> readAirplaneListfromJSON(String filePath) throws FileNotFoundException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        File file=new File(filePath);
        FileReader fileReader=new FileReader(file);
        Type listType=new TypeToken<ArrayList<Airplane>>(){}.getType();
        return gson.fromJson(fileReader,listType);
    }
    public static ArrayList<Order> readOrderListfromJSON(String filePath) throws FileNotFoundException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        File file=new File(filePath);
        FileReader fileReader=new FileReader(file);
        Type listType=new TypeToken<ArrayList<Order>>(){}.getType();
        return gson.fromJson(fileReader,listType);
    }
    public static int LoginScreen() throws IOException {
        User Login=new User();
        return Login.loginorregister();
    }
    public static void main(String[] Args) throws IOException {
        int ID=LoginScreen();
        initializeVehicles();
        GUI gui=new GUI();
        //   VehicleClass current=Trucks.get(0);
        //   System.out.println(current.getID()+": "+"Speed:"+current.getSpeed()+" Fuel Consumption per 100km:"+current.getFuelConsumption()+" Range:"+current.getRange()+" Weight Capacity:"+current.getWeightCapacity());
        writeOrderListtoJSON(Orders,"./OrdersInfo");
/*
        writeVehicleListtoJSON(Trucks,"./TrucksInfo");
        writeVehicleListtoJSON(Ships,"./ShipsInfo");
        writeVehicleListtoJSON(Airplanes,"./AirplanesInfo");
*/
    }
    public static void initializeOrdersRandomly(){
        Random random = new Random();
        for(int i = 0; i < 100; i++) {
            int orderID = i + 1;
            int orderDate = 20240101 + random.nextInt(1231); // Rough approximation for random dates in 2024

            // Create a random customer
            Customer customer = new Customer(
                    random.nextInt(1000) + 1,
                    "Customer" + (random.nextInt(1000) + 1),
                    "Address" + (random.nextInt(1000) + 1),
                    905000000 + random.nextInt(1000000000),
                    "customer" + (random.nextInt(1000) + 1) + "@hostname.com.tr"
            );

            // Create a random supplier
            Supplier supplier = new Supplier(
                    random.nextInt(100) + 1,
                    "Supplier" + (random.nextInt(100) + 1),
                    "Address" + (random.nextInt(100) + 1),
                    905000000 + random.nextInt(1000000000),
                    "supplier" + (random.nextInt(100) + 1) + "@hostname.com.tr"
            );

            // Create a random product
            Product product = new Product(
                    random.nextInt(1000) + 1,
                    "Product" + (random.nextInt(1000) + 1),
                    random.nextInt(100) + 1
            );

            // Create a random warehouse
            Warehouse warehouse = new Warehouse(
                    random.nextInt(10) + 1,
                    "Location" + (random.nextInt(10) + 1),
                    1000,
                    null
            );

            int quantity = random.nextInt(100) + 1;

            // Create the order with random data
            Orders.add(new Order(orderID, orderDate, customer.getCustomerID(), customer, supplier, warehouse, product, quantity));
        }
}
}
