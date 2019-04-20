package entities.product;

/**
 * ! \class Product, \brief kelas abstrak yang mendefinisikan produk yang
 * dihasilkan oleh kelas turunan FarmAnimal
 */
public abstract class Product {
    public final int price; // !< Atribut price int, harga produk
    public final String type; // !< Atribut type String , nama tipe produk

    /**
     * Ctor yang dipanggil melalui kelas turunannya
     * @param price harga produk
     * @param type  tipe produk
     */
    Product(int price, String type) {
        this.price = price;
        this.type = type;
    }

    /**
     * @return string tipe dari produk, dipanggil melalui kelas turunan
     */
    @Override
    public String toString() {
        return type;
    }
}
