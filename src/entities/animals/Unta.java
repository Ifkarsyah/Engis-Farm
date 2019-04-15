package entities.animals;

import entities.product.DagingUnta;
import entities.product.Product;
import entities.product.SusuUnta;

public class Unta extends FarmAnimal {
    public Unta(String name) {
        super(name, 15);
    }

    @Override
    public Product getProduct() {
        return new SusuUnta();
    }

    public Product getAnimalMeat() {
        return new DagingUnta();
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Alhamdulillah!");
    }

    @Override
    public char render() {
        return 'u';
    }
}