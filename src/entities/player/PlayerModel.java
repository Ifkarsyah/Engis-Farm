package entities.player;

import entities.Cell.Land;
import entities.Cell.Truck;
import entities.Cell.Well;
import entities.Renderable;
import entities.animals.FarmAnimal;
import entities.product.Product;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Represent PlayerModel
 *
 * @author ifkarsyah
 */
public class PlayerModel extends Renderable {
    private final Point point;
    private final LinkedList<Product> inventory;
    private int water = 20;
    private int money = 0;

    /**
     * Instantiate PlayerModel with initial position and empty inventory
     *
     * @param point initial position
     */
    public PlayerModel(Point point) {
        this.point = point;
        this.inventory = new LinkedList<>();
    }

    /**
     * Get player's point
     *
     * @return player's current point state
     */
    public Point getPoint() {
        return point;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Get player's inventory
     *
     * @return player's current inventory state
     */
    public LinkedList<Product> getInventory() {
        return inventory;
    }

    /**
     * Get player's representation in map
     *
     * @return representation of player in map
     */
    @Override
    public char render() {
        return 'P';
    }

    /**
     * Refill player's water when interacting with well
     * I.S: Random (TODO: what 'sembarang' means in English? Replace with it!
     * F.S: player's water added 100
     *
     * @param well the well player's interacting with
     */
    public void interact(Well well) {
        water += well.waterCapacity;
        if (water > 100)
            water = 100;
    }

    /**
     * Clear inventory by selling all product to truck
     * I.S: Random
     * F.S: player's inventory empty, truck's inventory is empty
     *
     * @param truck the truck player's interacting with
     */
    public void interact(Truck truck) {
        while (!inventory.isEmpty())
            money += inventory.removeFirst().price;
        truck.resetCooldownTime();
    }

    /**
     * Get product other than meat from animal
     * I.S: there's farmAnimal around player
     * F.S: can't get animal's product within sort time
     *
     * @param farmAnimal the animal player's interacting with
     */
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

    /**
     * Get meat from animal
     * I.S: there's farmAnimal around player
     * F.S: can't get animal's meat within sort time
     *
     * @param farmAnimal the animal player's interacting with
     */
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

    /**
     * Grow land in the same point with PlayerModel
     * I.S: Random
     * F.S: player's water reduced by 1 and land's grass is grew
     *
     * @param land the land PlayerModel standing
     */
    public void grow(Land land) {
        land.isGrassGrown = true;
        water--;
    }

    /**
     * Trigger animal to sound
     *
     * @param farmAnimal targeted animal
     */
    public void talk(FarmAnimal farmAnimal) {
        farmAnimal.makeSound();
    }

    /**
     * Print player's info
     *
     * @return player's info
     */
    @Override
    public String toString() {
        return "" + ("Money: " + money + "\n") + ("Water: " + water + "\n") + ("Inventory: " + Arrays.toString(inventory.toArray()) + "\n");
    }
}
