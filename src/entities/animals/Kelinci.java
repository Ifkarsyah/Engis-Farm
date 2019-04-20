package entities.animals;

import entities.product.DagingKelinci;
import entities.product.Product;

/**
 * \class Kelinci \brief Kelas turunan dari FarmAnimal
 */
public class Kelinci extends FarmAnimal {
    /**
     * \brief Ctor
     * 
     * @param name
     */
    public Kelinci(String name) {
        super(name, 10);
    }

    /**
     * \brief Menghasilkan objek kelas DagingKelinci \return DagingKelinci
     */
    @Override
    public Product getAnimalMeat() {
        return new DagingKelinci();
    }

    /**
     * \brief Menghasilkan suara Kelinci
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": HopHop!");
    }

    /**
     * Render icon Kelinci pada GUI /return char huruf K
     */
    @Override
    public char render() {
        return 'K';
    }

}
