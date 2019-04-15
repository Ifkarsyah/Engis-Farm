package entities.animals;

import entities.Cell.Land;
import entities.product.DagingBebek;
import entities.product.Product;
import entities.product.TelurBebek;


public class Bebek extends FarmAnimal {
    public Bebek(String name) {
        super(name, 20);
    }

    @Override
    public Product getProduct(){
        isProductReady = false;
        return new TelurBebek();
    }

    @Override
    public Product getAnimalMeat(){
        isProductReady = false;
        return new DagingBebek();
    }

    @Override
    public void makeSound(){
        System.out.println(name + ": Wikwik!");
    }

    @Override
    public char render() {
        return 'b';
    }

    @Override
    public boolean inCage(Land land){
        return land.type.equals("Barn") || land.type.equals("Coop");
    }
}
