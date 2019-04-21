package entities.player;

import entities.Cell.Land;
import entities.Cell.Truck;
import entities.Cell.Well;
import entities.Renderable;
import entities.animals.FarmAnimal;
import entities.product.Product;

import javax.swing.*;
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
     *
     * Konstruktor PlayerModel. Menginisialisasi point dari player
     * @param point initial position
     */
    public PlayerModel(Point point) {
        this.point = point;
        this.inventory = new LinkedList<>();
    }

    /**
     *
     * Mendapatkan point dari palyer
     * @return point player sekarang
     */
    public Point getPoint() {
        return point;
    }

    /**
     *
     * Mendapatkan jumlah air dari player
     * @return int jumlah air
     */
    public int getWater() {
        return water;
    }

    /**
     *
     * Mendapatkan banyaknya uang dari player
     * @return int banyaknya uang
     */
    public int getMoney() {
        return money;
    }

    /**
     *
     * Mendapatkan inventory dari player
     * @return LinkedList<Product> inventori player
     */
    public LinkedList<Product> getInventory() {
        return inventory;
    }

    /**
     *
     * Mendapatkan representasi dari player di map
     * @return char 'P'
     */
    @Override
    public char render() {
        return 'P';
    }

    /**
     * Menambah jumlah air dari player
     * I.S: Random
     * F.S: Jumlah air dari player bertambah 50
     * @param well
     */
    public void interact(Well well) {
        water += well.waterCapacity;
        if (water > 100)
            water = 100;
    }

    /**
     * Mengosongkan inventory dan menjual semua barang yang ada
     * I.S: Random
     * F.S: Inventori kosong
     * @param truck
     */
    public void interact(Truck truck) {
        while (!inventory.isEmpty())
            money += inventory.removeFirst().price;
        truck.resetCooldownTime();
    }

    /**
     * Mendapatkan product dari suatu animal
     * I.S: Terdapat animal di sekitar player
     * F.S: product didapat, product belum siap, atau hean tidak memiliki product
     * @param farmAnimal
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
     * Mendapatkan daging dari suatu animal
     * I.S: Terdapat animal di sekitar player
     * F.S: daging ditambahkan di inventori dan hewan mati.
     * @param farmAnimal
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
     * Menumbuhkan rumput di point yang sama dengan player
     * I.S: Random
     * F.S: Water berkurang 1 dan tumbuh tumput
     * @param land
     */
    public void grow(Land land) {
        land.isGrassGrown = true;
        water--;
    }

    /**
     *
     * Player berbicara dengan hewan
     * @param farmAnimal
     */
    public void talk(FarmAnimal farmAnimal) {
        farmAnimal.makeSound();
    }

    /**
     *
     * Print informasi player
     * @return informasi player
     */
    @Override
    public String toString() {
        return "" + ("Money: " + money + "\n") + ("Water: " + water + "\n") + ("Inventory: " + Arrays.toString(inventory.toArray()) + "\n");
    }

    /**
     *
     * Menghasilkan filename gambar player
     * @return ImageIcon
     */
    @Override
    public ImageIcon renderGUI(){
        return new ImageIcon("img/Player.png");
    }
}
