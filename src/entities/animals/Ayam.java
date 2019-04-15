package entities.animals;

import entities.product.DagingAyam;
import entities.product.Product;
import entities.product.TelurAyam;


public class Ayam extends FarmAnimal {
    public Ayam(String name) {
        super(name, 10);
    }

    @Override
    public Product getProduct() {
        return new TelurAyam();
    }

    @Override
    public Product getAnimalMeat() {
        return new DagingAyam();
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Petok, petok!");
    }

    @Override
    public char render() {
        return 'A';
    }
}