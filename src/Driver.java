public class Driver {
    int driverID;

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    Vehicle vehicle;
    String name;
    String address;
    int phoneNo; //in the format of 905384567845  starting with country code with no '+'. Has 12 digits.
    String email;  // in the format of customermail@hostname.com.tr 1 example is yenoloji@gmail.com
    public Driver(int ID,Vehicle vehicle,String name,String address,int phoneNo,String email){
        driverID=ID;
        this.vehicle=vehicle;
        this.name=name;
        this.address=address;
        this.phoneNo=phoneNo;
        this.email=email;
    }
}
