package com.capco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Firas on 7/29/2018.
 */
public class Course {
    @JsonIgnore
    private long id;
    private String courseName;
    private String teacherName;
    private List<Schedule> schedules = new ArrayList<>();

    public Course(long id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public Course(String courseName){
        this(0, courseName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void insertSchedule(Schedule newSchedule){
        this.schedules.add(newSchedule);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
