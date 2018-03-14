package models;

import java.util.Set;

public class Lesson {

    private int id;
    private String title;
    private double room;
    private Set<Student> students;

    public Lesson() {
    }

    public Lesson(String title, double room) {
        this.title = title;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRoom() {
        return room;
    }

    public void setRoom(double room) {
        this.room = room;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
