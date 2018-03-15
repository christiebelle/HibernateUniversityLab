import db.DBHelper;
import models.Course;
import models.Instructor;
import models.Lesson;
import models.Student;
import org.junit.After;
import org.junit.Before;

public class TestInstructor {

    Instructor instructor;
    Course course;
    Student student;
    Lesson lesson;

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(instructor);
        DBHelper.delete(student);
        DBHelper.delete(lesson);
        DBHelper.delete(course);
    }

    @Before
    public void setUp() throws Exception {
        instructor = new Instructor("Queen Elizabeth");
        DBHelper.save(instructor);
        course = new Course("");
        DBHelper.save(course);
        student = new Student("Portia", 19, 1605, course);
        DBHelper.save(instructor);
    }
}
