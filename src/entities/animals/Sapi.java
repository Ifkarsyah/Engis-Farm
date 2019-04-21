package entities.animals;

import entities.product.DagingSapi;
import entities.product.Product;
import entities.product.SusuSapi;

import javax.swing.*;

/**
 * Sapi binatang turunan dari FarmAnimal
 * 
 */
public class Sapi extends FarmAnimal {

    /**
     * Ctor 
     * 
     * @param name String berisi nama dari binatang Sapi tersebut
     */
    public Sapi(String name) {
        super(name, 40, "Moooo!");
    }

    /**
     * Menghasilkan produk susu Sapi dari kelas Sapi 
     * @return SusuSapi
     * 
     */
    @Override
    public Product getProduct() {
        return new SusuSapi();
    }

    /**
     * Menghasilkan DagingSapi dari kelas Sapi 
     * @return DagingSapi
     */
    @Override
    public Product getAnimalMeat() {
        return new DagingSapi();
    }

    /**
     * Menghasilkan suara Sapi
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": Mooooooo!");
    }

    /**
     * Menghasilkan icon Sapi 'S' 
     * @return char
     * 
     */
    @Override
    public char render() {
        return 'S';
    }

    /**
     * Menghasilkan filename gambar sapi
     * @return ImageIcon
     *
     */
    @Override
    public ImageIcon renderGUI() {
        if (hungryPoint > 5)
            return new ImageIcon(Sapi.class.getResource("/img/Sapi.png"));
        else
            return new ImageIcon(Sapi.class.getResource("/img/Sapi-hungry.png"));
    }

    public boolean isHabitat(char c){
        return c == '#' || c == '-';
    }

}
