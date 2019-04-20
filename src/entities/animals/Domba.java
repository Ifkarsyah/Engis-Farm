package entities.animals;

import entities.product.DagingDomba;
import entities.product.Product;

/*!
 * \class Domba \brief binatang turunan dari FarmAnimal
 * 
 */
public class Domba extends FarmAnimal {

    /*
     * ! \brief Ctor \param name String berisi nama dari binatang Domba tersebut
     */
    public Domba(String name) {
        super(name, 15);
    }

    /*
     * ! \brief Menghasilkan DagingDomba dari kelas Domba \return DagingDomba
     */
    @Override
    public Product getAnimalMeat() {
        return new DagingDomba();
    }

    /*
     * ! \brief Menghasilkan suara Domba
     */
    @Override
    public void makeSound() {
        System.out.println(name + ": Mbeeek!");
    }

    /*
     * \brief Menghasilkan icon Domba 'D' \return char
     * 
     */
    @Override
    public char render() {
        return 'D';
    }

}
