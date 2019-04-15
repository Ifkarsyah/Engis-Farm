package entities.product;

public abstract class Product {
    public final int price;
    public final String type;

    Product(int price, String type) {
        this.price = price;
        this.type = type;
    }


    @Override
    public String toString() {
        return type;
    }
}
