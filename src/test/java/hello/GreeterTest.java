package hello;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class GreeterTest {

    @Mock
    private Counter counter;

    @InjectMocks  //asendab counter mock counteriga
    private Greeter greeter = new Greeter();

    @Before  //käivitatakse enne igat testi
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void greets_short_string() {
        //given
        when(counter.count(anyString())).thenReturn(1);
        //when
        String result = greeter.sayHello("ami");
        //then
        assertEquals("Wow that's a short name, ami, welcome!", result);
    }

    @Test
    public void greets_medium_string() {
        //given
        when(counter.count(anyString())).thenReturn(6);
        //when
        String result = greeter.sayHello("helena");
        //then
        assertEquals("Hello, helena, welcome! Your name is 6 characters long", result);
    }

    @Test
    public void greets_long_string() {
        //given
        when(counter.count(anyString())).thenReturn(20);
        //when
        String result = greeter.sayHello("ami");
        //then
        assertEquals("Who are you?", result);
    }

    @Test
    public void greets_no_name() {
        //given
        when(counter.count(anyString())).thenReturn(0);
        //when
        String result = greeter.sayHello("helena");
        //then
        assertEquals("Who are you?", result);
    }
}
