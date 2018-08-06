package com.capco.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Firas on 7/28/2018.
 */
public class Student {
    private long id;
    private String name;
    private Major major;
    private List<Course> courses = new ArrayList<>();

    public Student(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Student(String name){
        this(-1, name);
    }

    public Student(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void insertCourse(Course newCourse){
        this.courses.add(newCourse);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major=" + major +
                ", courses=" + courses +
                '}';
    }
}
