package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {

    private int id;
    private String title;
    private String level;
    private Set<Instructor> teachers;
    private Set<Student> students;
    private Set<Lesson> lessons;

    public Course() {
    }

    public Course(String title, String level) {
        this.title = title;
        this.level = level;
        this.teachers = new HashSet<Instructor>();
        this.lessons = new HashSet<Lesson>();
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

    @Column(name="level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    @ManyToMany
    @JoinTable(name="instructor_courses",
    joinColumns = {@JoinColumn(name="course_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="instructor_id", nullable = false, updatable = false)})
    public Set<Instructor> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Instructor> teachers) {
        this.teachers = teachers;
    }

    public void assignLessons(Lesson lesson){
        this.lessons.add(lesson);
    }

    public void addStudentToCourse(Student student){
        this.students.add(student);
    }

    public void addInstructorToCourse(Instructor instructor){
        this.teachers.add(instructor);
    }


}
