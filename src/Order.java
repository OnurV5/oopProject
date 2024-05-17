public class Order {
    int orderID;
    int orderDate;  // in the format of YYYYMMDD so 16.05.2024 is represented as 20240516;
    int customerID;
    int quantity;

    public Order(int orderID, int orderDate, int customerID, Customer customer, Supplier supplier, Warehouse warehouse,int quantity) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerID = customerID;
        this.customer = customer;
        this.supplier = supplier;
        this.warehouse = warehouse;
        this.quantity=quantity;
    }

    public int getOrderDate() {
        return orderDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public int getOrderID() {
        return orderID;
    }


    Customer customer;
    Supplier supplier;
    Warehouse warehouse;
}
