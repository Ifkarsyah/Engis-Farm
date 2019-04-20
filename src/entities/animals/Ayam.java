package entities.animals;

import entities.product.DagingAyam;
import entities.product.Product;
import entities.product.TelurAyam;

/*!
 * \class Ayam \brief binatang turunan dari FarmAnimal
 * 
 */
public class Ayam extends FarmAnimal {
    /*
     * ! \brief Ctor \param name String berisi nama dari binatang Ayam tersebut
     */
    public Ayam(String name) {
        super(name, 10);
    }

    /*
     * ! \brief Menghasilkan produk telur Ayam dari kelas Ayam \return TelurAyam
     */
    @Override
    public Product getProduct() {
        return new TelurAyam();
    }

    /*
     * ! \brief Menghasilkan DagingAyam dari kelas Ayam \return DagingAyam
     */
    @Override
    public Product getAnimalMeat() {
        return new DagingAyam();
    }

    /*
     * ! \brief Menghasilkan suara Ayam
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": Petok, petok!");
    }

    /*
     * ! \brief Menghasilkan icon Ayam 'A' \return char
     * 
     */
    @Override
    public char render() {
        return 'A';
    }
}
