import db.DBHelper;
import models.Course;
import models.Lesson;
import models.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.security.pkcs11.Secmod;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestCourse {

    private Course course;
    private Lesson lesson;
    private Student student;

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(student);
        DBHelper.delete(lesson);
        DBHelper.delete(course);
    }

    @Before
    public void setUp() throws Exception {
        course = new Course("How to invade France", "BSc");
        DBHelper.save(course);
        lesson = new Lesson("Attack Harfleur", 14.15, course);
        DBHelper.save(lesson);
        student = new Student("Biondello", 23, 1593, course);
        DBHelper.save(student);
    }

    @Test
    public void testCourseTitle() {
        assertEquals("How to invade France", course.getTitle());
    }

    @Test
    public void testCanSave() {
        List<Course> result = DBHelper.getAll(Course.class);
        assertEquals(1, result.size());
    }

    @Test
    public void testCanAddLesson() {
        course.assignLessons(lesson);
        assertEquals(1, course.getLessons().size());
    }

    @Test
    public void testCanAddStudent() {
        course.addStudentToCourse(student);
        assertEquals(1, course.getStudents().size());
    }
}
