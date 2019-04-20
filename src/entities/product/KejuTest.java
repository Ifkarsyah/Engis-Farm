package entities.product;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class KejuTest {

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
    public void testKeju() {
        Keju b = new Keju();
        assertEquals(b.getPrice(), 100000);
        assertEquals(b.toString(), "Keju");

        LinkedList<Product> dummy = new LinkedList<>();

        dummy.add(ss);
        dummy.add(su);

        assertEquals(dummy.toString(),b.ingredients.toString());
    }
}