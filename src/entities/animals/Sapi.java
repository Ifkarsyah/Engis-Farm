package entities.animals;

import entities.product.DagingSapi;
import entities.product.Product;
import entities.product.SusuSapi;


public class Sapi extends FarmAnimal {
    public Sapi(String name) {
        super(name, 15);
    }

    @Override
    public Product getProduct() {
        return new SusuSapi();
    }

    @Override
    public Product getAnimalMeat() {
        return new DagingSapi();
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Mooooooo!");
    }

    @Override
    public char render() {
        return 's';
    }

}
