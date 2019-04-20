package entities.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DagingDombaTest {

    DagingDomba x = new DagingDomba();

    @Test
    void getPrice() {
        assertEquals(x.getPrice(),50000);
    }

    @Test
    void toString1() {
        assertEquals(x.toString(), "DagingDomba");
    }
}