import db.DBHelper;
import models.Course;
import models.Lesson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestLesson {

    private Lesson lesson;
    private Course course;

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(course);
        DBHelper.delete(lesson);
    }

    @Before
    public void setUp() throws Exception {
        course = new Course("How to destroy your Best Pal", "MA");
        DBHelper.save(course);
        lesson = new Lesson("Target the Protegee, 101", 1.01, course);
        DBHelper.save(lesson);
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
}
