import db.DBHelper;
import models.Course;
import models.Lesson;
import models.Student;

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


    }
}
