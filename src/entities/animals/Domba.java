package entities.animals;

import entities.product.DagingDomba;
import entities.product.Product;

import javax.swing.*;

/**
 * Domba binatang turunan dari FarmAnimal
 * 
 */
public class Domba extends FarmAnimal {

    /**
     * Ctor
     * @param name String berisi nama dari binatang Domba tersebut
     */
    public Domba(String name) {
        super(name, 30, "Mbeek!");
    }

    /**
     * Menghasilkan DagingDomba dari kelas Domba 
     * @return DagingDomba
     */
    @Override
    public Product getAnimalMeat() {
        return new DagingDomba();
    }

    /**
     * Menghasilkan suara Domba
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": Mbeeek!");
    }

    /**
     * Menghasilkan icon Domba 'D' 
     * @return char
     * 
     */
    @Override
    public char render() {
        return 'D';
    }

    /**
     * Menghasilkan filename gambar Domba
     * @return ImageIcon
     *
     */
    @Override
    public ImageIcon renderGUI(){
        if (hungryPoint > 5)
            return new ImageIcon("img/Domba.png");
        else
            return new ImageIcon("img/Domba-hungry.png");
    }

    public boolean isHabitat(char c){
        return c == '@' || c == '#' || c == 'x' || c == '-';
    }
}
