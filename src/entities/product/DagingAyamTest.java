package entities.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DagingAyamTest {

    DagingAyam x = new DagingAyam();

    @Test
    void getPrice() {
        assertEquals(x.getPrice(),30000);
    }

    @Test
    void toString1() {
        assertEquals(x.toString(), "DagingAyam");
    }
}