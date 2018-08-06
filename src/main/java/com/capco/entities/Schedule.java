package com.capco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Firas on 8/5/2018.
 */
public class Schedule {
    @JsonIgnore
    private long courseId;
    private String fromHour;
    private String toHour;
    private String room;
    private String day;

    public Schedule(String from, String to, String room, String day){
        this.fromHour = from;
        this.toHour = to;
        this.room = room;
        this.day = day;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "courseId=" + courseId +
                ", fromHour='" + fromHour + '\'' +
                ", toHour='" + toHour + '\'' +
                ", room='" + room + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
