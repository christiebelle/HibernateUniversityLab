import db.DBHelper;
import models.Course;
import models.Lesson;
import models.Student;

import java.util.List;


public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("How to invade France", "BSc");
        DBHelper.save(course1);

        Lesson lesson1 = new Lesson("Attacking Harfleur", 141.5, course1);
        DBHelper.save(lesson1);

        Lesson lesson2 = new Lesson("How to Win at Agincourt", 14.15, course1);
        DBHelper.save(lesson2);

        Student student1 = new Student("Pedant", 18, 1898, course1);
        DBHelper.save(student1);

        Student student2 = new Student("Petruchio", 27, 1590, course1);
        DBHelper.save(student2);

        Student student3 = new Student("Bianca", 21, 1591, course1);
        DBHelper.save(student3);

        Student student4 = new Student("Grumio", 46, 1592, course1);
        DBHelper.save(student4);

        DBHelper.assignStudentToLesson(student1, lesson1);
        DBHelper.assignStudentToLesson(student2, lesson1);
        DBHelper.assignStudentToLesson(student3, lesson2);
        DBHelper.assignStudentToLesson(student4, lesson2);

        List<Student> enrolledStudents = DBHelper.getEnrolledStudents(lesson1.getId());
        List<Student> enrolledStudents1 = DBHelper.getEnrolledStudents(lesson2.getId());

        Lesson studentsInLesson = DBHelper.find(Lesson.class, lesson1.getId());

        Course lessonsOnCourse = DBHelper.find(Course.class, course1.getId());

        List<Lesson> courseLessons = DBHelper.listLessonsForCourse(course1);
        List<Student> courseStudents = DBHelper.listStudentsByCourse(course1);

    }
}
