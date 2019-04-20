package entities.product;

/**
 * class Burger merupakan turunan dari kelas SideProduct
 */
public class Burger extends SideProduct {
    /**
     * Ctor, inisialisasi Harga dan nama Produk pada kelas SideProduct,
     * serta bahan bahan dari kelas Product yang dibutuhkan untuk membuat Burger
     */
    public Burger() {
        super(20000, "Burger");
        ingredients.add(new DagingUnta());
        ingredients.add(new DagingKelinci());
        ingredients.add(new TelurAyam());
        ingredients.add(new SusuSapi());
        ingredients.add(new Keju());
    }
}
