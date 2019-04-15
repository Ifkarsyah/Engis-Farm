package entities.animals;

import entities.Cell.Land;
import entities.Renderable;
import entities.product.Product;


public abstract class FarmAnimal extends Renderable {
    public static int numOfFarmAnimal = 0;
    final String name;
    private final int hungerTime;
    boolean isProductReady;
    private int hungryPoint;


    FarmAnimal(String name, int hungerTime) {
        this.name = name;
        this.hungerTime = hungerTime;
        this.hungryPoint = this.hungerTime;
        this.isProductReady = true;
        numOfFarmAnimal++;
    }

    public boolean isHungry() {
        return hungryPoint <= 5;
    }

    public void becomeHungrier() {
        hungryPoint--;
    }

    public boolean isStarving() {
        return hungryPoint <= 0;
    }

    public void eat(Land land) {
        if (isHungry() && land.isGrassGrown) {
            land.isGrassGrown = false;
            isProductReady = true;
        }
    }

    public Product getProduct() throws Exception {
        throw new Exception("NoProductException");
    }

    public Product getAnimalMeat() throws Exception {
        throw new Exception("NoMeatException");
    }

    public abstract void makeSound();


}
