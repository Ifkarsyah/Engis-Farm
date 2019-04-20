package tests.product_test;

import static org.junit.Assert.*;
import entities.product.*;
import org.junit.Test;


public class productTest{

    @Test
    public void ProductConstructorTest(){

        DagingAyam da = new DagingAyam();
        assertEquals(da.toString(),"DagingAyam");

    }
}