package entities.animals;

import entities.product.DagingSapi;
import entities.product.SusuSapi;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SapiTest {

    private static final String NAMA = "Sapiku";

    @Test
    public void testSapi() {

        Sapi A = new Sapi(NAMA);

        assertEquals(A.getName(), NAMA);
        assertEquals(A.getHungryPoint(), 40);
        assertEquals(A.getSound(), "Moooo!");

    }

    @Test
    public void testGetProduct() {
        Sapi A = new Sapi(NAMA);
        SusuSapi T = new SusuSapi();
        assertEquals(A.getProduct().getClass(), T.getClass());
    }

    @Test
    public void testGetAnimalMeat() {
        Sapi A = new Sapi(NAMA);
        DagingSapi D = new DagingSapi();
        assertEquals(A.getAnimalMeat().getClass(), D.getClass());
    }

    @Test
    public void testRender() {
        Sapi A = new Sapi(NAMA);
        assertEquals(A.render(),'S');
    }

    @Test
    public void testRenderGUI() {
        Sapi A = new Sapi(NAMA);
        assertEquals(A.renderGUI().getClass(), new ImageIcon("img/Sapi.png").getClass());
    }
}