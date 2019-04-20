package entities.product;

/**
 * ! \class Sate merupakan turunan dari kelas SideProduct
 */
public class Sate extends SideProduct {
    
    /**
     * Ctor inisialisasi Harga dan nama Produk pada kelas SideProduct,
     * serta bahan bahan dari kelas Product yang dibutuhkan untuk membuat Sate
     */
    public Sate() {
        super(45000, "Sate");
        ingredients.add(new DagingAyam());
        ingredients.add(new DagingBebek());
        ingredients.add(new DagingDomba());
        ingredients.add(new DagingKelinci());
        ingredients.add(new DagingSapi());
        ingredients.add(new DagingUnta());
        ingredients.add(new TelurBebek());
    }
}
