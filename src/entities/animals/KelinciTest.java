package entities.animals;

import entities.product.DagingKelinci;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KelinciTest {

    private static final String NAMA = "Kelinciku";
    @Test
    public void testKelinci() {

        Kelinci K = new Kelinci(NAMA);

        assertEquals(K.getName(), NAMA);
        assertEquals(K.getHungryPoint(), 30);
        assertEquals(K.getSound(), "Hop! Hop!");

    }

    @Test
    public void testGetProduct() {
        Kelinci K = new Kelinci(NAMA);
        Exception thrown = assertThrows(Exception.class, ()-> K.getProduct(), "NoProductException");
        assertEquals(thrown.getMessage(),"NoProductException");
    }

    @Test
    public void testGetAnimalMeat() {
        Kelinci K = new Kelinci(NAMA);
        DagingKelinci D = new DagingKelinci();
        assertEquals(K.getAnimalMeat().getClass(), D.getClass());
    }

    @Test
    public void testRender() {
        Kelinci K = new Kelinci(NAMA);
        assertEquals(K.render(),'K');
    }

    @Test
    public void testRenderGUI() {
        Kelinci K = new Kelinci(NAMA);
        assertEquals(K.renderGUI().getClass(), new ImageIcon("img/Kelinci.png").getClass());
    }
}