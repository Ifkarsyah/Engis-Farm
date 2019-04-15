package entities.animals;

import entities.product.DagingSapi;
import entities.product.Product;
import entities.product.SusuSapi;


public class Sapi extends FarmAnimal {
    public Sapi(String name) {
        super(name, 20);
    }

    @Override
    public Product getProduct() {
        numOfFarmAnimal--;
        isProductReady = false;
        return new SusuSapi();
    }

    @Override
    public Product getAnimalMeat() {
        numOfFarmAnimal--;
        isProductReady = false;
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
