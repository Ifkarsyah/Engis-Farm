package entities.animals;

import entities.Cell.Land;
import entities.product.DagingKelinci;
import entities.product.Product;


public class Kelinci extends FarmAnimal {
    public Kelinci(String name) {
        super(name, 20);
    }

    @Override
    public Product getAnimalMeat(){
        isProductReady = false;
        return new DagingKelinci();
    }

    @Override
    public void makeSound(){
        System.out.println(name + ": HopHop!");
    }

    @Override
    public char render() {
        return 'k';
    }

    @Override
    public boolean inCage(Land land){
        return land.type.equals("Barn");
    }
}
