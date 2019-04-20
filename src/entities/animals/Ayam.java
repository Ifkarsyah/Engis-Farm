package entities.animals;

import entities.product.DagingAyam;
import entities.product.Product;
import entities.product.TelurAyam;

/*
 * Ayam binatang turunan dari FarmAnimal
 * 
 */
public class Ayam extends FarmAnimal {
    /*
     * Ctor
     * @param name String berisi nama dari binatang Ayam tersebut
     */
    public Ayam(String name) {
        super(name, 10);
    }

    /*
     * Menghasilkan produk telur Ayam dari kelas Ayam \return TelurAyam
     * @return TelurAyam
     */
    @Override
    public Product getProduct() {
        return new TelurAyam();
    }

    /*
     * Menghasilkan DagingAyam dari kelas Ayam \return DagingAyam
     * @return DagingAyam
     */
    @Override
    public Product getAnimalMeat() {
        return new DagingAyam();
    }

    /*
     * Menghasilkan suara Ayam
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": Petok, petok!");
    }

    /*
     * Menghasilkan icon Ayam 'A' \
     * @return char
     * 
     */
    @Override
    public char render() {
        return 'A';
    }
}
