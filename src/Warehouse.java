public class Warehouse {
    int warehouseID;

    public Warehouse(int warehouseID, String location, int capacity, Order[] storedOrders) {
        this.warehouseID = warehouseID;
        this.location = location;
        this.capacity = capacity;
        this.storedOrders = storedOrders;
    }

    String location;

    public int getCapacity() {
        return capacity;
    }

    public int getWarehouseID() {
        return warehouseID;
    }
    public String getLocation() {
        return location;
    }
    public Order[] getStoredOrders() {
        return storedOrders;
    }

    public void setStoredOrders(Order[] storedOrders) {
        this.storedOrders = storedOrders;
    }

    int capacity;
    Order[] storedOrders;

}
