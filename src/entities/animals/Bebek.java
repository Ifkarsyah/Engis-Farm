package entities.animals;

import entities.product.DagingBebek;
import entities.product.Product;
import entities.product.TelurBebek;


public class Bebek extends FarmAnimal {
    public Bebek(String name) {
        super(name, 10);
    }

    @Override
    public Product getProduct() {
        return new TelurBebek();
    }

    @Override
    public Product getAnimalMeat() {
        return new DagingBebek();
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Wik, wik!");
    }

    @Override
    public char render() {
        return 'B';
    }

}