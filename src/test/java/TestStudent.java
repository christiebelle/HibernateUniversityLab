import db.DBHelper;
import models.Course;
import models.Lesson;
import models.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestStudent {

    private Course course;
    private Student student;
    private Lesson lesson;

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(course);
        DBHelper.delete(lesson);
        DBHelper.delete(student);

    }

    @Before
    public void setUp() throws Exception {
    course = new Course("How to stop your Families fighting", "MLit");
    DBHelper.save(course);
    student = new Student("Romeo", 20, 1234, course);
    DBHelper.save(student);
    lesson = new Lesson("How not to take poison", 15.97, course);
    }

    @Test
    public void testHasStudentNo() {
        assertEquals(1234, student.getStudentno());
    }

    @Test
    public void testHasCourse() {
        assertEquals("How to stop your Families fighting", student.getCourse().getTitle());
    }

    @Test
    public void testCanSave() {
        List<Student> results = DBHelper.getAll(Student.class);
        assertEquals(1, results.size());
    }

    @Test
    public void testAddLesson() {
        student.addToLesson(lesson);
        assertEquals(1, student.getLessons().size());
    }
}
