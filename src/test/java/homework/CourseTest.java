package homework;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.PublicHolidayService;

import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

//came with exception:
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;   //add junit to classpath (and i did it btw)

public class CourseTest {
    ZonedDateTime startDate = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
    ZonedDateTime endDate = ZonedDateTime.parse("2020-01-20T00:00:00.000+00:00[UTC]");
    ZonedDateTime birthdate = ZonedDateTime.parse("1980-09-02T00:00:00.000+00:00[UTC]");
    Teacher teacher = new Teacher("inna", "19191919", birthdate, "matemaatika", "74747474");

    @Mock
    private PublicHolidayService publicHolidayService = new PublicHolidayService();

    @InjectMocks
    private Course course = new Course("suhtlemispsühholoogia", 5, startDate, endDate, teacher);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void day_length() {
        //given - long, päevade arv
        long expected_results = 14L;

        //when
        long result = course.getLength();

        //then
        assertEquals(expected_results, result);
    }

    @Test
    public void tagastab_negatiivse() {  //test failed: tegelikult tagastab "wtf" (else)
        //given
        startDate = ZonedDateTime.parse("2020-03-18T00:00:00.000+00:00[UTC]");
        endDate = ZonedDateTime.parse("2020-03-05T00:00:00.000+00:00[UTC]");
        Course course = new Course("mehhatroonika", 10, startDate, endDate, teacher);
        long expected_results = -10L;

        //when
        long result = course.getLength();

        //then
        assertEquals(expected_results, result);
    }

    @Test
    public void tagastab_nulli() { //test failed: tegelikult tagastab "wtf" (else)
        //given
        startDate = ZonedDateTime.parse("2020-03-05T00:00:00.000+00:00[UTC]");
        endDate = ZonedDateTime.parse("2020-03-05T00:00:00.000+00:00[UTC]");
        Course course = new Course("automaattestimine", 15, startDate, endDate, teacher);
        long expected_results = 0;

        //when
        long result = course.getLength();

        //then
        assertEquals(expected_results, result);
    }

    @Test
    public void getWorkingDaysWrongOrderThrowsIllegalArgumentException() { //tuli "wtf" instead of "nii ei saa" :(
        //given
        endDate = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        startDate = ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]");
        when(publicHolidayService.getPublicHolidaysOnWorkdays(startDate, endDate)).thenReturn(1);
        Course course = new Course("Astronoomiline teleportatsioon", 10, startDate, endDate, teacher);
        String expected_result = "nii ei saa";

        //when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> course.getLength());

        //then
        assertEquals(expected_result,exception.getMessage());
    }
}