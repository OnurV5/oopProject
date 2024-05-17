public class Product {
int productID;
String name;

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public Product(int productID, String name, int unitPrice) {
        this.productID = productID;
        this.name = name;
        this.unitPrice = unitPrice;
    }

int unitPrice;

}
