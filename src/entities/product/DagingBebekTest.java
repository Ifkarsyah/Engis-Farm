package entities.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DagingBebekTest {

    DagingBebek x = new DagingBebek();

    @Test
    void getPrice() {
        assertEquals(x.getPrice(),35000);
    }

    @Test
    void toString1() {
        assertEquals(x.toString(), "DagingBebek");
    }
}