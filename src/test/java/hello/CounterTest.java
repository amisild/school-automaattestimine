package hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CounterTest {
    private Counter counter = new Counter();

    @Test
    public void counts () {
        int result = counter.count("ami");
        assertEquals(3, result);
    }

    @Test
    public void counts_string_and_space () {
        int result = counter.count("helena jäe");
        assertEquals(10, result);
    }

    @Test
    public void counts_space () {
        int result = counter.count(" ");
        assertEquals(1, result);
    }

    @Test
    public void counts_empty () {
        int result = counter.count("");
        assertEquals(0, result);
    }
}
