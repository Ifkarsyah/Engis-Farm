package entities.Cell;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    void resetCooldownTime() {
        Truck T = new Truck(new Point(0,0));
        T.reduceCooldownTime();
        T.resetCooldownTime();
        assertEquals(T.getCoolDownTime(),30);
    }

    @Test
    void reduceCooldownTime() {
        Truck T = new Truck(new Point(0,0));
        T.reduceCooldownTime();
        assertEquals(T.getCoolDownTime(),29);
    }

    @Test
    void testRender() {
        Point P = new Point(10, 5);
        Truck x = new Truck(P);
        assertEquals(x.render(),'T');
    }

    @Test
    void testRenderGUI() {
        Point P = new Point(10, 5);
        Truck x = new Truck(P);
        assertEquals(x.renderGUI().toString(),"img/Truck.png");
    }
}