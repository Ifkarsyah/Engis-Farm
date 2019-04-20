package entities.animals;

import entities.product.DagingUnta;
import entities.product.Product;
import entities.product.SusuUnta;

import javax.swing.*;

/**
 * Unta, Turunan dari kelas FarmAnimal
 */
public class Unta extends FarmAnimal {
    /**
     * Ctor 
     * @param name String
     * 
     */
    public Unta(String name) {
        super(name, 40, "Alhamdulillah");
    }

    /**
     * Menghasilkan produk SusuUnta 
     * @return SusuUnta
     */
    @Override
    public Product getProduct() {
        return new SusuUnta();
    }

    /**
     * Mengembalikan DagingUnta 
     * @return DagingUnta
     */
    public Product getAnimalMeat() {
        return new DagingUnta();
    }

    /**
     * Menghasilkan suara Unta
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": Alhamdulillah!");
    }

    /**
     * Menghasilkan icon Unta 'U' yang akan dirender pada GUI
     * 
     * @return char
     */
    @Override
    public char render() {
        return 'U';
    }

    @Override
    public ImageIcon renderGUI() {
        return new ImageIcon("img/Unta.png");
    }
}