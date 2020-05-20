package homework;

import org.junit.Test;
import java.time.ZonedDateTime;
import static org.junit.Assert.assertEquals;

public class TeacherTest {

    ZonedDateTime birthdate = ZonedDateTime.parse("1970-01-01T00:00:00.000+00:00[UTC]");
    Teacher teacher = new Teacher("aaa", "654321", birthdate, "matemaatika", "12345");

    //testime sayhello
    @Test
    public void sayHello() {
        String result = "aaa";
        assertEquals(teacher.sayHello(), result);
    }
    //expected:Hello, aaa
    //actual:aaa

}