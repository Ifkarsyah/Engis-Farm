package entities.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DagingKelinciTest {

    DagingKelinci x = new DagingKelinci();

    @Test
    void getPrice() {
        assertEquals(x.getPrice(),25000);
    }

    @Test
    void toString1() {
        assertEquals(x.toString(), "DagingKelinci");
    }

}