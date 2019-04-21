package entities.product;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SateTest {

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
    public void testSate() {
        Sate b = new Sate();
        assertEquals(b.getPrice(), 45000);
        assertEquals(b.toString(), "Sate");

        LinkedList<Product> dummy = new LinkedList<>();

        dummy.add(da);
        dummy.add(db);
        dummy.add(dd);
        dummy.add(dk);
        dummy.add(ds);
        dummy.add(du);
        dummy.add(tb);

        assertEquals(dummy.toString(),b.ingredients.toString());
    }

}