package entities;

import entities.Cell.Land;
import entities.Cell.Truck;
import entities.Cell.Well;
import entities.animals.FarmAnimal;
import entities.product.Product;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Player extends Renderable {
    private Point point;
    private int water = 20;
    private int money = 0;
    private LinkedList<Product> inventory;

    public Player(Point point) {
        this.point = point;
        this.inventory = new LinkedList<>();
    }

    public Point getPoint() {
        return point;
    }

    public LinkedList<Product> getInventory() {
        return inventory;
    }

    @Override
    public char render() {
        return 'p';
    }

    public void interact(Well well) {
        water += well.waterCapacity;
        if (water > 100)
            water = 100;
    }

    public void interact(Truck truck) {
        while (!inventory.isEmpty())
            money += inventory.removeFirst().price;
        truck.resetCooldownTime();
    }

    public void interact(FarmAnimal farmAnimal) {
        try {
            if (farmAnimal.isProductReady) {
                inventory.add(farmAnimal.getProduct());
                farmAnimal.isProductReady = false;
            } else {
                System.err.println("Product is not ready");
            }
        } catch (Exception e) {
            System.err.println("Cannot interact with this animal.");
        }
    }

    public void kill(FarmAnimal farmAnimal) {
        try {
            if (farmAnimal.isProductReady) {
                inventory.add(farmAnimal.getAnimalMeat());
                farmAnimal.isProductReady = false;
            } else {
                System.err.println("Meat is not ready");
            }
        } catch (Exception e) {
            System.err.println("Cannot kill this animal.");
        }
    }

    public void grow(Land land) {
        land.isGrassGrown = true;
        water--;
    }

    public void talk(FarmAnimal farmAnimal) {
        farmAnimal.makeSound();
    }

    @Override
    public String toString() {
        return "" + ("Money: " + money + "\n") + ("Water: " + water + "\n") + ("Inventory: " + Arrays.toString(inventory.toArray()) + "\n");
    }
}
