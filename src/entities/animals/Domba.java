package entities.animals;

import entities.product.DagingDomba;
import entities.product.Product;


public class Domba extends FarmAnimal {
    public Domba(String name) {
        super(name, 20);
    }

    @Override
    public Product getAnimalMeat() {
        isProductReady = false;
        return new DagingDomba();
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Wikwik!");
    }

    @Override
    public char render() {
        return 'd';
    }


}
