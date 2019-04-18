package entities.animals;

import entities.product.DagingDomba;
import entities.product.Product;


public class Domba extends FarmAnimal {
    public Domba(String name) {
        super(name, 15);
    }

    @Override
    public Product getAnimalMeat() {
        return new DagingDomba();
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Mbeeek!");
    }

    @Override
    public char render() {
        return 'D';
    }


}
