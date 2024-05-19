public class Driver {
    int driverID;
    public int getDriverID() { return driverID; }
    public void setDriverID(int driverID) { this.driverID = driverID; }
    public VehicleClass getVehicle() { return vehicle; }
    public void setVehicle(VehicleClass vehicle) { this.vehicle = vehicle; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String  phoneNo) { this.phoneNo = phoneNo; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    static VehicleClass vehicle;
    String name;
    String address;
    String  phoneNo; //in the format of 905384567845 starting with country code without '+'. Has 12 digits.
    String email; // in the format of customermail@hostname.com.tr 1 example is yenoloji@gmail.com
    public Driver(int ID,VehicleClass vehicle,String name,String address,String phoneNo,String email){
        driverID=ID;
        this.vehicle=vehicle;
        this.name=name;
        this.address=address;
        this.phoneNo=phoneNo;
        this.email=email;
    }
}