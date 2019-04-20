package entities.animals;

import entities.product.DagingUnta;
import entities.product.Product;
import entities.product.SusuUnta;

/**
 * \class Unta \brief Turunan dari kelas FarmAnimal
 */
public class Unta extends FarmAnimal {
    /**
     * \brief Ctor \param name String
     */
    public Unta(String name) {
        super(name, 20);
    }

    /**
     * \brief Menghasilkan produk SusuUnta \return SusuUnta
     */
    @Override
    public Product getProduct() {
        return new SusuUnta();
    }

    /**
     * \brief Mengembalikan DagingUnta \return DagingUnta
     */
    public Product getAnimalMeat() {
        return new DagingUnta();
    }

    /**
     * \brief Menghasilkan suara Unta
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": Alhamdulillah!");
    }

    /**
     * \brief Menghasilkan icon Unta 'U' yang akan dirender pada GUI
     */
    @Override
    public char render() {
        return 'U';
    }
}