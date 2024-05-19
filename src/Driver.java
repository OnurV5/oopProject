public class Driver {
    static int driverID;
    public static int getDriverID() { return driverID; }
    public void setDriverID(int driverID) { this.driverID = driverID; }
    public static Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public static String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public static String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public static String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String  phoneNo) { this.phoneNo = phoneNo; }
    public static String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    static Vehicle vehicle;
    static String name;
    static String address;
    static String  phoneNo; //in the format of 905384567845 starting with country code without '+'. Has 12 digits.
    static String email; // in the format of customermail@hostname.com.tr 1 example is yenoloji@gmail.com
    public Driver(int ID,Vehicle vehicle,String name,String address,String phoneNo,String email){
        driverID=ID;
        this.vehicle=vehicle;
        this.name=name;
        this.address=address;
        this.phoneNo=phoneNo;
        this.email=email;
    }
}