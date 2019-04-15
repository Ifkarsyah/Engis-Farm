package entities.product;

import java.util.LinkedList;

public abstract class SideProduct extends Product {
    public final LinkedList<Product> ingredients;

    SideProduct(int price, String type) {
        super(price, type);
        this.ingredients = new LinkedList<>();
    }
}
