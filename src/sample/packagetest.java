package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class packagetest{
    @Test
    public void testCreatePackage(){

        Package small = new Package(30.0, 30.0, 15.0, 1.0, 4.0);

        assertEquals((Double)30.0,small.getLength());
        assertEquals((Double)30.0,small.getWidth());
        assertEquals((Double)15.0,small.getHeight());
        assertEquals((Double)1.0,small.getWeight());
        assertEquals((Double)4.0,small.getPrize());


    }
    
}
