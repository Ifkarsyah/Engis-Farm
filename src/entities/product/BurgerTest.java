package entities.product;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {

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



    @Test
    public void testBurger() {
        Burger b = new Burger();
        assertEquals(b.getPrice(), 20000);
        assertEquals(b.toString(), "Burger");

        LinkedList<Product> dummy = new LinkedList<>();

        dummy.add(du);
        dummy.add(dk);
        dummy.add(ta);
        dummy.add(ss);
        dummy.add(k);

        assertEquals(dummy.toString(),b.ingredients.toString());
    }

}