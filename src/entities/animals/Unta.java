package entities.animals;

import entities.product.DagingUnta;
import entities.product.Product;
import entities.product.SusuUnta;


public class Unta extends FarmAnimal {
    public Unta(String name) {
        super(name, 20);
    }

    @Override
    public Product getProduct() {
        numOfFarmAnimal--;
        isProductReady = false;
        return new SusuUnta();
    }

    public Product getAnimalMeat() {
        numOfFarmAnimal--;
        isProductReady = false;
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
