package homework;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends PersonImpl {

    public List<Course> courses;

    private String nimi;
    private String personId;
    private ZonedDateTime birthdate;
    private String kursus;
    private String studentId;

    //constructor
    public Student(String nimi, String personId, ZonedDateTime birthdate, String kursus, String studentId) {
        super(nimi, personId, birthdate, kursus, studentId);
        this.nimi = nimi;
        this.personId = personId;
        this.birthdate = birthdate;
        this.kursus = kursus;
        this.studentId = studentId;
    }

    //override
    @Override
    public String sayHello() {
        super.sayHello();
        return "Hello student " + getFirstName();
    }

    //getter ja setter
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    //list, mis tagastab õppejõudude nimesid
    public List<String> showAllTeachersNames (List<Course> courses) {
        this.courses = courses;

        List<String> teachersNames = new ArrayList<String>();

        for (Course course : courses) {
            teachersNames.add(course.getTeacher().getNimi());
        }

        return teachersNames;

    }

    public List<String> getAllTeacherNames() {
        return this.getCourses().stream().map(Course::getName).collect(Collectors.toList());

    }


}
