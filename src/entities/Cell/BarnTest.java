package entities.Cell;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BarnTest {
    @Test
    public void testBarnConstructorAndSetterGetterPoint() {
        for (int i = -32000; i < 32000; i++) {
            Point P = new Point(i, i);
            Barn b = new Barn(P);
            assertEquals(true, b.getPoint().getX() == P.getX() &&
                    b.getPoint().getY() == P.getY());
        }
    }

    @Test
    void testRenderGrown() {
        Point P = new Point(0, 0);
        Barn b = new Barn(P);
        b.isGrassGrown = true;
        assertEquals(b.render(),'@');
    }
    @Test
    void testRenderNotGrown() {
        Point P = new Point(0, 0);
        Barn b = new Barn(P);
        b.isGrassGrown = false;
        assertEquals(b.render(),'x');
    }

    @Test
    void testRenderGUIGrown() {
        Point P = new Point(0, 0);
        Barn b = new Barn(P);
        b.isGrassGrown = true;
        assertEquals(b.renderGUI().toString(),"img/Barn-grass.png");
    }

    @Test
    void testRenderGUINotGrown() {
        Point P = new Point(0, 0);
        Barn b = new Barn(P);
        b.isGrassGrown = false;
        assertEquals(b.renderGUI().toString(),"img/Barn.png");
    }
}