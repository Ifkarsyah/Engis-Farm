package entities.animals;

import entities.product.DagingBebek;
import entities.product.Product;
import entities.product.TelurBebek;

/*!
 * \class Bebek \brief binatang turunan dari FarmAnimal
 * 
 */
public class Bebek extends FarmAnimal {

    /*
     * ! \brief Ctor \param name String berisi nama dari binatang Bebek tersebut
     */
    public Bebek(String name) {
        super(name, 10);
    }

    /*
     * \brief Menghasilkan produk telur Bebek dari kelas Bebek \return TelurBebek
     */
    @Override
    public Product getProduct() {
        return new TelurBebek();
    }

    /*
     * \brief Menghasilkan DagingBebek dari kelas Bebek \return DagingBebek
     */
    @Override
    public Product getAnimalMeat() {
        return new DagingBebek();
    }

    /*
     * \brief Menghasilkan suara Bebek
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": Wik, wik!");
    }

    /*
     * \brief Menghasilkan icon Bebek 'A' \return char
     * 
     */
    @Override
    public char render() {
        return 'B';
    }

}