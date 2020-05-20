package homework;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PersonImpl implements Person {
    private String nimi;
    private String personId;
    private ZonedDateTime birthdate;
    private String kursus;
    private String studentId;

    public PersonImpl(String nimi, String personId, ZonedDateTime birthdate, String kursus, String studentId) {
        this.nimi = nimi;
        this.personId = personId;
        this.birthdate = birthdate;
        this.kursus = kursus;
        this.studentId = studentId;
    }

    @Override
    public String getFirstName() {
        return this.nimi;
    }

    @Override
    public ZonedDateTime getDateOfBirth() {
        return this.birthdate;
    }

    @Override
    public Long getAge() {
        return ChronoUnit.YEARS.between(this.birthdate, ZonedDateTime.now());
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

    public String getNimi() {
        return this.nimi;
    }
}
