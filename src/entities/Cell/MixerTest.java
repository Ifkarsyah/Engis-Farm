package entities.Cell;

import entities.product.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MixerTest {



    @Test
    void MixerConstructorAndSetterGetterPointTest() {
        Point P = new Point(10, 5);
        Mixer m = new Mixer(P);
        assertEquals(
                true, m.getPoint().getX() == P.getX() && m.getPoint().getY() == P.getY());
    }

    @Test
    void testMix() {

        DagingAyam da = new DagingAyam();
        DagingBebek db = new DagingBebek();
        DagingDomba dd = new DagingDomba();
        DagingKelinci dk = new DagingKelinci();
        DagingSapi ds = new DagingSapi();
        DagingUnta du = new DagingUnta();
        SusuSapi ss = new SusuSapi();
        SusuUnta su = new SusuUnta();
        TelurAyam ta = new TelurAyam();
        TelurBebek tb = new TelurBebek();
        Keju k = new Keju();
        Burger b = new Burger();
        Sate s = new Sate();

        Mixer m = new Mixer(new Point(0,0));
        System.out.println("--- Before Mix | Inventory ---");

        LinkedList<Product> l = new LinkedList<>();
        l.add(ss);
        l.add(su);
        l.add(da);
        l.add(su);
        l.add(su);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).type);
        }

        m.mix(l, k);

        System.out.println("--- After Mix | Inventory ---");
        for (int i = 0; i < l.size(); i++) {
            System.out.println((l.get(i).type));
        }

    }

    @Test
    void testRender() {
        Point P = new Point(10, 5);
        Mixer x = new Mixer(P);
        assertEquals(x.render(),'M');
    }

    @Test
    void testRenderGUI() {
        Point P = new Point(10, 5);
        Mixer x = new Mixer(P);
        assertEquals(x.renderGUI().toString(),"img/Mixer.png");
    }
}