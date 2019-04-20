package entities.product;

/**
 * ! \class Keju merupakan turunan dari kelas SideProduct
 */
public class Keju extends SideProduct {
    /**
     * Ctor, inisialisasi Harga dan nama Produk pada kelas SideProduct,
     * serta bahan bahan dari kelas Product yang dibutuhkan untuk membuat Keju
     */
    public Keju() {
        super(100000, "Keju");
        ingredients.add(new SusuSapi());
        ingredients.add(new SusuUnta());
    }
}
