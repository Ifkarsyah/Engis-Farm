package entities.animals;

import entities.Cell.Land;
import entities.Renderable;
import entities.product.Product;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class FarmAnimal extends Renderable {
    public static int numOfFarmAnimal = 0;
    final String name;
    private int hungryPoint;
    private final int hungerTime;
    private Point point;
    boolean isProductReady;


    FarmAnimal(String name, int hungerTime) {
        this.name = name;
        this.hungerTime = hungerTime;
        this.hungryPoint = this.hungerTime;
        this.point = new Point(ThreadLocalRandom.current().nextInt(0, 10),
                               ThreadLocalRandom.current().nextInt(0, 11));
        this.isProductReady = true;
        numOfFarmAnimal++;
    }

    public Point getPoint() {
        return point;
    }

    private boolean isHungry(){ return hungryPoint <= 5; }
    public void becomeHungrier() { hungryPoint--; }
    public boolean isStarving(){
        numOfFarmAnimal--;
        return hungryPoint <= 0;
    }
    public void eat(Land land){
        if (isHungry() && land.isGrassGrown) {
            land.isGrassGrown = false;
            isProductReady = true;
        }
    }

    public Product getProduct() throws Exception {
        throw new Exception("NoProductException");
    }
    public abstract Product getAnimalMeat();

    public abstract void makeSound();

    public abstract boolean inCage(Land land);


}
