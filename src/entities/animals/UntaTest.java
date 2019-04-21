package entities.animals;

import entities.product.DagingUnta;
import entities.product.SusuUnta;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class UntaTest {

    private static final String NAMA = "Untaku";

    @Test
    public void testUnta() {

        Unta A = new Unta(NAMA);

        assertEquals(A.getName(), NAMA);
        assertEquals(A.getHungryPoint(), 40);
        assertEquals(A.getSound(), "Alhamdulillah");

    }

    @Test
    public void testGetProduct() {
        Unta A = new Unta(NAMA);
        SusuUnta T = new SusuUnta();
        assertEquals(A.getProduct().getClass(), T.getClass());
    }

    @Test
    public void testGetAnimalMeat() {
        Unta A = new Unta(NAMA);
        DagingUnta D = new DagingUnta();
        assertEquals(A.getAnimalMeat().getClass(), D.getClass());
    }

    @Test
    public void testRender() {
        Unta A = new Unta(NAMA);
        assertEquals(A.render(),'U');
    }

    @Test
    public void testRenderGUI() {
        Unta A = new Unta(NAMA);
        assertEquals(A.renderGUI().getClass(), new ImageIcon("img/Unta.png").getClass());
    }
}