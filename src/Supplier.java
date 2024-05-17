public class Supplier {
    int supplierID;
    String name;
    String address;

    public String getAddress() {
        return address;
    }

    public Supplier(int supplierID, String name, String address, int phoneNo, String email) {
        this.supplierID = supplierID;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    int phoneNo; //in the format of 905384567845  starting with country code with no '+'. Has 12 digits.
    String email;  // in the format of customermail@hostname.com.tr 1 example is yenoloji@gmail.com
}
