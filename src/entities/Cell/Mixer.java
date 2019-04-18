package entities.Cell;

import entities.product.Product;
import entities.product.SideProduct;

import java.awt.*;
import java.util.LinkedList;

public class Mixer extends Cell {
    public Mixer(Point point) {
        super(point);
    }

    public void mix(LinkedList<Product> playerInventory, SideProduct sideProduct) {
        for (Product p : sideProduct.ingredients) {
            if (!playerInventory.removeIf(inv -> inv.type.equals(p.type)))
                return;
        }
        playerInventory.add(sideProduct);
    }

    @Override
    public char render() {
        return 'M';
    }
}
