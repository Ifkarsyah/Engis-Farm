package entities;

import entities.Cell.Land;
import entities.Cell.Truck;
import entities.Cell.Well;
import entities.animals.FarmAnimal;
import entities.product.Product;

import java.awt.*;
import java.util.LinkedList;

public class Player extends Renderable {
    private Point point;
    private int water;
    private int money;
    private LinkedList<Product> inventory;

    public Player(Point point, int water, int money) {
        this.point = point;
        this.water = water;
        this.money = money;
        this.inventory = new LinkedList<>();
    }

    public Point getPoint() {
        return point;
    }

    public int getWater() {
        return water;
    }

    public int getMoney() {
        return money;
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
        if (water > 100) water = 100;
    }

    public void interact(Truck truck) {
        while (!inventory.isEmpty()) {
            Product product = inventory.removeFirst();
            money += product.price;
        }
        truck.resetCooldownTime();
    }

    public void interact(FarmAnimal farmAnimal) {
        try {
            Product product = farmAnimal.getProduct();
            inventory.add(product);
        } catch (Exception e) {
            System.err.println("Cannot interact with this animal.");
        }
    }

    public void kill(FarmAnimal farmAnimal) {
        try {
            Product product = farmAnimal.getAnimalMeat();
        } catch (Exception e) {
            System.err.println("Cannot kill this animal.");
        }
    }

    public void grow(Land land) {
        land.isGrassGrown = true;
    }

    public void talk(FarmAnimal farmAnimal) {
        farmAnimal.makeSound();
    }
}
