package entities.animals;

import entities.product.DagingKelinci;
import entities.product.Product;


public class Kelinci extends FarmAnimal {
    public Kelinci(String name) {
        super(name, 10);
    }

    @Override
    public Product getAnimalMeat() {
        return new DagingKelinci();
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": HopHop!");
    }

    @Override
    public char render() {
        return 'K';
    }


}
