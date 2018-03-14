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
    private Instructor teacher;
    private Set<Student> students;

    public Lesson() {
    }

    public Lesson(String title, double room, Course course, Instructor teacher) {
        this.title = title;
        this.room = room;
        this.course = course;
        this.teacher = teacher;
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
    @JoinColumn(name="instructor_id", nullable = false)
    public Instructor getTeacher() {
        return teacher;
    }

    public void setTeacher(Instructor teacher) {
        this.teacher = teacher;
    }

    public void addStudentToLesson(Student student){
        this.students.add(student);
    }
}
