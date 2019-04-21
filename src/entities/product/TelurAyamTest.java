package entities.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelurAyamTest {

    TelurAyam x = new TelurAyam();

    @Test
    void getPrice() {
        assertEquals(x.getPrice(),2000);
    }

    @Test
    void toString1() {
        assertEquals(x.toString(), "TelurAyam");
    }

}