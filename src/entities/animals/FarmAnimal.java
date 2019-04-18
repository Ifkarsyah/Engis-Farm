package entities.animals;

import entities.Cell.Land;
import entities.Renderable;
import entities.product.Product;


public abstract class FarmAnimal extends Renderable {
    final String name;
    private final int hungerTime;
    public boolean isProductReady = true;
    private int hungryPoint;

    FarmAnimal(String name, int hungerTime) {
        this.name = name;
        this.hungryPoint = this.hungerTime = hungerTime;
    }

    public void becomeHungrier() {
        hungryPoint--;
    }

    public boolean isDeath() {
        return hungryPoint <= 0;
    }

    public void eat(Land land) {
        if (hungryPoint <= 5 && land.isGrassGrown) {
            land.isGrassGrown = false;
            isProductReady = true;
            hungryPoint = hungerTime;
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
