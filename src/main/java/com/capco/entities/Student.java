package com.capco.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Firas on 7/28/2018.
 */
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private long registrationYear;
    private float averageGPA;
    private Major major;
    private List<Course> courses = new ArrayList<>();

    public Student(long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName){
        this(0, firstName, lastName);
    }

    public Student(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(long registrationYear) {
        this.registrationYear = registrationYear;
    }

    public float getAverageGPA() {
        return averageGPA;
    }

    public void setAverageGPA(float averageGPA) {
        this.averageGPA = averageGPA;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registrationYear=" + registrationYear +
                ", averageGPA=" + averageGPA +
                ", major=" + major +
                ", courses=" + courses +
                '}';
    }
}
