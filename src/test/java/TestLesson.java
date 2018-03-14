import db.DBHelper;
import models.Course;
import models.Instructor;
import models.Lesson;
import models.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.security.pkcs11.Secmod;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestLesson {

    private Lesson lesson;
    private Course course;
    private Student student;
    private Instructor teacher;

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(course);
        DBHelper.delete(lesson);
        DBHelper.delete(student);
        DBHelper.delete(teacher);
    }

    @Before
    public void setUp() throws Exception {
        teacher = new Instructor("William Shakespeare");
        DBHelper.save(teacher);
        course = new Course("How to destroy your Best Pal", "MA");
        DBHelper.save(course);
        lesson = new Lesson("Target the Protegee, 101", 1.01, course, teacher);
        DBHelper.save(lesson);
        student = new Student("Iago", 21, 1603, course);
        DBHelper.save(student);
    }

    @Test
    public void testHasRoom() {
        assertEquals( 1.01, lesson.getRoom(),0.01);
    }

    @Test
    public void testHasCourse() {
        assertEquals("How to destroy your Best Pal", lesson.getCourse().getTitle());
    }

    @Test
    public void testCanSave() {
        List<Lesson> results = DBHelper.getAll(Lesson.class);
        assertEquals(1, results.size());
    }

    @Test
    public void testAddStudent() {
        lesson.addStudentToLesson(student);
        assertEquals(1, lesson.getStudents().size());
    }
}
