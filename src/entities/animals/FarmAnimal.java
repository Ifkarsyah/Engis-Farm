package entities.animals;

import entities.Cell.Land;
import entities.Renderable;
import entities.product.Product;

/**
 * class FarmAnimal merupakan kelas abstrak turunan dari kelas
 * Renderable
 */
public abstract class FarmAnimal extends Renderable {
    final String name; // !< Atribut nama berupa String yang akan dinisiasi pada kelas yang menurunkan
                       // FarmAnimal
    private final int hungerTime; // !< Atribut hungerTime berupa integer , setiap tipe binatang yang berbeda akan
                                  // memiliki hungerTime yang berbeda-beda

    public boolean isProductReady = true; // <! Atribut yang menandakan apakah fungsi GetProduct bisa digunakan pada
                                          // sebuah kelas binatang
    private int hungryPoint; // <! Atribut yang menandakan status tingkat kelaparan hewan
    final String sound;

    /**
     * Ctor, inisialisasi dengan parameter nama hewan dan waktu lapar hewan
     * 
     * @param name Nama hewan
     * @param hungerTime waktu lapar
     * 
     */
    FarmAnimal(String name, int hungerTime, String sound) {
        this.name = name;
        this.hungryPoint = this.hungerTime = hungerTime;
        this.sound = sound;
    }

    /**
     * Fungsi yang membuat hewan makin lapar, dipanggil dari fungsi lain setiap
     * waktu tertentu
     */
    public void becomeHungrier() {
        hungryPoint--;
    }

    /**
     * Fungsi yang mengecek apakah hewan sudah mati atau belum
     * 
     * @return boolean, true jika hungryPoint nya sudah 0
     */
    public boolean isDeath() {
        return hungryPoint <= 0;
    }

    /**
     * Fungsi yang meningkatkan hungryPoint hewan, dan membuat land tempat
     * hewan berada hilang rumputnya
     * 
     * @param land
     */
    public void eat(Land land) {
        if (hungryPoint <= 5 && land.isGrassGrown) {
            land.isGrassGrown = false;
            isProductReady = true;
            hungryPoint = hungerTime;
        }
    }

    /**
     * Fungsi yang mengembalikan produk dan dipanggil dari kelas yang
     * menurunkan FarmAnimal, jika tidak memiliki produk akan melepar Exception dan
     * pengambilan produk gagal
     * 
     * @return Product Produk (non-daging) dari Kelas Hewan yang menurunkan FarmAnimal
     * @throws Exception jika tidak memiliki produk "NoProductException"
     */
    public Product getProduct() throws Exception {
        throw new Exception("NoProductException");
    }

    /**
     * Fungsi yang mengembalikan daging dari hewan
     * 
     * @return Product Daging dari kelas hewan yang menurunkan FarmAnimal
     * @throws Exception "NoMeatException"
     */
    public Product getAnimalMeat() throws Exception {
        throw new Exception("NoMeatException");
    }

    /**
     * Fungsi abstrak yang mengeluarkan suara hewan sesuai jenis hewannya
     */
    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }
}
