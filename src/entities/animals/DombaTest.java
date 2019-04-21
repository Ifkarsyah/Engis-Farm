package entities.animals;

import entities.product.DagingDomba;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DombaTest {

    private static final String NAMA = "MBE";
    @Test
    public void testDomba() {

        Domba D = new Domba(NAMA);

        assertEquals(D.getName(), NAMA);
        assertEquals(D.getHungryPoint(), 30);
        assertEquals(D.getSound(), "Mbeek!");

    }

    @Test
    public void testGetProduct() {
        Domba D = new Domba(NAMA);
        Exception thrown = assertThrows(Exception.class, ()-> D.getProduct(), "NoProductException");
        assertEquals(thrown.getMessage(),"NoProductException");
    }

    @Test
    public void testGetAnimalMeat() {
        Domba D = new Domba(NAMA);
        DagingDomba Da = new DagingDomba();
        assertEquals(D.getAnimalMeat().getClass(), Da.getClass());
    }

    @Test
    public void testRender() {
        Domba D = new Domba(NAMA);
        assertEquals(D.render(),'D');
    }

    @Test
    public void testRenderGUI() {
        Domba D = new Domba(NAMA);
        assertEquals(D.renderGUI().getClass(), new ImageIcon("img/Domba.png").getClass());
    }
}