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
import java.util.Random;

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
    static public void initializeVehicles() throws FileNotFoundException {
        Trucks=readTruckListfromJSON("./TrucksInfo");
        Ships=readShipListfromJSON("./ShipsInfo");
        Airplanes=readShipListfromJSON("./AirplanesInfo");
        System.out.println("Vehicle Lists Initialized!");

    }
    public static void writeVehicleListtoJSON(ArrayList<VehicleClass> list,String filePath) throws IOException {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        File file=new File(filePath);
        FileWriter fileWriter=new FileWriter(file);
        gson.toJson(list,fileWriter);
        fileWriter.close();
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
    public static void main(String[] Args) throws IOException {
        initializeVehicles();
        System.out.println("Done!");
/*
        writeVehicleListtoJSON(Trucks,"./TrucksInfo");
        writeVehicleListtoJSON(Ships,"./ShipsInfo");
        writeVehicleListtoJSON(Airplanes,"./AirplanesInfo");

 */
    }
}
