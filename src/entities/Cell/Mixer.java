package entities.Cell;

import entities.product.Product;
import entities.product.SideProduct;

import java.awt.*;
import java.util.LinkedList;

public class Mixer extends Cell {

    /**
     * Konstuktor dari mixer
     * 
     * @param point
     */
    public Mixer(Point point) {
        super(point);
    }


    /**
     * Metode untuk melakukan mix
     * @param playerInventory inventori dari player
     * @param sideProduct Produk yang ingin dibuat
     */

    public void mix(LinkedList<Product> playerInventory, SideProduct sideProduct) {
        for (Product p : sideProduct.ingredients) {
            if (!playerInventory.removeIf(inv -> inv.type.equals(p.type)))
                return;
        }
        playerInventory.add(sideProduct);
    }

    /**
     * Override fungsi render()
     * @return char
     */

    @Override
    public char render() {
        return 'M';
    }
}
