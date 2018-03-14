package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lessons")
public class Lesson {

    private int id;
    private String title;
    private double room;
    private Course course;
    private Instructor instructor;
    private Set<Student> students;

    public Lesson() {
    }

    public Lesson(String title, double room, Course course, Instructor instructor) {
        this.title = title;
        this.room = room;
        this.course = course;
        this.instructor = instructor;
        this.students = new HashSet<Student>();
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

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="classroom")
    public double getRoom() {
        return room;
    }

    public void setRoom(double room) {
        this.room = room;
    }

    @ManyToMany(mappedBy = "lessons", fetch = FetchType.EAGER)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name="lesson_id", nullable = false)
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void addStudentToLesson(Student student){
        this.students.add(student);
    }
}
