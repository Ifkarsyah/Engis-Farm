package entities.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DagingSapiTest {

    DagingSapi x = new DagingSapi();

    @Test
    void getPrice() {
        assertEquals(x.getPrice(),80000);
    }

    @Test
    void toString1() {
        assertEquals(x.toString(), "DagingSapi");
    }

}