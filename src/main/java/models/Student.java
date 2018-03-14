package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {

    private int id;
    private String name;
    private int age;
    private int studentno;
    private Course course;
    private Set<Lesson> lessons;

    public Student() {
    }

    public Student(String name, int age, int studentno, Course course) {
        this.name = name;
        this.age = age;
        this.studentno = studentno;
        this.course = course;
        this.lessons = new HashSet<Lesson>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name="student_number")
    public int getStudentno() {
        return studentno;
    }

    public void setStudentno(int studentno) {
        this.studentno = studentno;
    }

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToMany
    @JoinTable(name="student_lessons",
    joinColumns = {@JoinColumn(name="student_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="lesson_id", nullable = false, updatable = false)})
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addToLesson(Lesson lesson){
        this.lessons.add(lesson);
    }
}
