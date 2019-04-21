package entities.Cell;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WellTest {
    @Test
    void testWell() {
        Point P = new Point(10, 5);
        Well x = new Well(P);
        assertEquals(x.waterCapacity, 30);
        assertEquals(
                true, x.getPoint().getX() == P.getX() && x.getPoint().getY() == P.getY());
    }

    @Test
    void testRender() {
        Point P = new Point(10, 5);
        Well x = new Well(P);
        assertEquals(x.render(),'W');
    }

    @Test
    void testRenderGUI() {
        Point P = new Point(10, 5);
        Well x = new Well(P);
        assertEquals(x.renderGUI().toString(),"img/Well.png");
    }
}