package entities.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelurBebekTest {


    TelurBebek x = new TelurBebek();

    @Test
    void getPrice() {
        assertEquals(x.getPrice(),3000);
    }

    @Test
    void toString1() {
        assertEquals(x.toString(), "TelurBebek");
    }

}