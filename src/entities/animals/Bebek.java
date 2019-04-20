package entities.animals;

import entities.product.DagingBebek;
import entities.product.Product;
import entities.product.TelurBebek;

import javax.swing.*;

/**
 * Bebek binatang turunan dari FarmAnimal
 * 
 */
public class Bebek extends FarmAnimal {

    /**
     * Ctor
     * 
     * @param name String berisi nama dari binatang Bebek tersebut
     * 
     */
    public Bebek(String name) {
        super(name, 20, "Wik, wik!");
    }

    /**
     * Menghasilkan produk telur Bebek dari kelas Bebek 
     * 
     * @return TelurBebek
     */
    @Override
    public Product getProduct() {
        return new TelurBebek();
    }

    /**
     * Menghasilkan DagingBebek dari kelas Bebek
     * 
     * @return DagingBebek
     */
    @Override
    public Product getAnimalMeat() {
        return new DagingBebek();
    }

    /**
     * Menghasilkan suara Bebek
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": Wik, wik!");
    }

    /**
     * Menghasilkan icon Bebek 'A'
     * 
     * @return char
     */
    @Override
    public char render() {
        return 'B';
    }

    /**
     * Menghasilkan filename gambar bebek
     * @return ImageIcon
     *
     */
    @Override
    public ImageIcon renderGUI(){
        if (hungryPoint > 5)
            return new ImageIcon("img/Bebek.png");
        else
            return new ImageIcon("img/Bebek-hungry.png");
    }
}