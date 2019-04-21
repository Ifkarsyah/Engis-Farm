package entities.product;

import java.util.LinkedList;

/**
 * Kelas yang berisi objek yang dapat dihasilkan
 * dengan kombinasi dari Product dan/atau SideProduct itu sendiri
 */
public abstract class SideProduct extends Product {

    public final LinkedList<Product> ingredients; // !< Atribut ingredients, berisi bahan-bahan apa saja untuk
                                                  // membuatSideProduct, berbeda untuk setiap SideProduct.

    /**
     * Ctor, inisiasi harga dan tipe side product melalui kelas turunannya
     * @param price harga produk
     * @param type String tipe produk
     * 
     */
    SideProduct(int price, String type) {
        super(price, type);
        this.ingredients = new LinkedList<>();
    }


}
