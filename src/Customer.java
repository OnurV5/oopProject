public class Customer {
    int customerID;
    String name;
    String address;

    public Customer(int customerID, String name, String address, int phoneNo, String email) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    int phoneNo; //in the format of 905384567845  starting with country code with no '+'. Has 12 digits.
    String email;  // in the format of customermail@hostname.com.tr 1 example is yenoloji@gmail.com
}
