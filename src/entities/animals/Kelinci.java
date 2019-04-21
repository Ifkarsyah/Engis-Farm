package entities.animals;

import entities.product.DagingKelinci;
import entities.product.Product;

import javax.swing.*;

/**
 * Kelinci turunan dari FarmAnimal
 */
public class Kelinci extends FarmAnimal {
    /**
     * Ctor
     * 
     * @param name
     */
    public Kelinci(String name) {
        super(name, 30, "Hop! Hop!");
    }

    /**
     * Menghasilkan objek kelas DagingKelinci 
     * @return DagingKelinci
     */
    @Override
    public Product getAnimalMeat() {
        return new DagingKelinci();
    }

    /**
     * Menghasilkan suara Kelinci
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": HopHop!");
    }

    /**
     * Render icon Kelinci pada GUI 
     * @return char huruf K
     */
    @Override
    public char render() {
        return 'K';
    }

    /**
     * Menghasilkan filename gambar kelinci
     * @return ImageIcon
     *
     */
    @Override
    public ImageIcon renderGUI(){
        if (hungryPoint > 5)
            return new ImageIcon(Kelinci.class.getResource("/img/Kelinci.png"));
        else
            return new ImageIcon(Kelinci.class.getResource("/img/Kelinci-hungry.png"));
    }

    public boolean isHabitat(char c){
        return c == '@' || c == '#' || c == 'x' || c == '-';
    }
}
