import db.DBHelper;
import models.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestCourse {

    private Course course;

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(course);

    }

    @Before
    public void setUp() throws Exception {
        course = new Course("How to invade France", "BSc");
        DBHelper.save(course);
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
}
