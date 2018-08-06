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
    private String name;
    private List<Schedule> schedules = new ArrayList<>();

    public Course(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(String name){
        this(-1, name);
    }

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
                ", name='" + name + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
