public class Shipping {
    int shippingID;
    Order order;

    public Shipping(int shippingID, Order order, String shippingWay) {
        this.shippingID = shippingID;
        this.order = order;
        this.shippingWay = shippingWay;
    }

    public Order getOrder() {
        return order;
    }

    public String getShippingWay() {
        return shippingWay;
    }

    public int getShippingID() {
        return shippingID;
    }


    String shippingWay;  //airline, marine or road transportation
}
