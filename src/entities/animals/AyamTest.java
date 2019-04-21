package entities.animals;

import entities.product.DagingAyam;
import entities.product.TelurAyam;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AyamTest {

    /**
     *
     */

    private static final String AKOI = "Akoi";

    @Test
    public void testAyam() {

        Ayam A = new Ayam(AKOI);

        assertEquals(A.getName(), AKOI);
        assertEquals(A.getHungryPoint(), 20);
        assertEquals(A.getSound(), "Petok, petok!");

    }

    @Test
    public void testGetProduct() {
        Ayam A = new Ayam(AKOI);
        TelurAyam T = new TelurAyam();
        assertEquals(A.getProduct().getClass(), T.getClass());
    }

    @Test
    public void testGetAnimalMeat() {
        Ayam A = new Ayam(AKOI);
        DagingAyam D = new DagingAyam();
        assertEquals(A.getAnimalMeat().getClass(), D.getClass());
    }

    @Test
    public void testRender() {
        Ayam A = new Ayam(AKOI);
        assertEquals(A.render(),'A');
    }

    @Test
    public void testRenderGUI() {
        Ayam A = new Ayam(AKOI);
        assertEquals(A.renderGUI().getClass(), new ImageIcon("img/Ayam.png").getClass());
    }

}