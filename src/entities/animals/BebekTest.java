package entities.animals;

import entities.product.DagingBebek;
import entities.product.TelurBebek;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BebekTest {

    private static final String NAMA = "Bambek";

    @Test
    public void testBebek() {

        Bebek B = new Bebek(NAMA);

        assertEquals(B.getName(), NAMA);
        assertEquals(B.getHungryPoint(), 20);
        assertEquals(B.getSound(), "Wik, wik!");

    }

    @Test
    public void testGetProduct() {
        Bebek B = new Bebek(NAMA);
        TelurBebek T = new TelurBebek();
        assertEquals(B.getProduct().getClass(), T.getClass());
    }

    @Test
    public void testGetAnimalMeat() {
        Bebek B = new Bebek(NAMA);
        DagingBebek D = new DagingBebek();
        assertEquals(B.getAnimalMeat().getClass(), D.getClass());
    }

    @Test
    public void testRender() {
        Bebek B = new Bebek(NAMA);
        assertEquals(B.render(),'B');
    }

    @Test
    public void testRenderGUI() {
        Bebek B = new Bebek(NAMA);
        assertEquals(B.renderGUI().getClass(), new ImageIcon("img/Bebek.png").getClass());
    }
}