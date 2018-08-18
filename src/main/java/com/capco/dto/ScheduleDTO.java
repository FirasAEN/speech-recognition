package com.capco.dto;

import com.capco.entities.Schedule;

/**
 * Created by Firas on 8/18/2018.
 */
public class ScheduleDTO {
    private Schedule schedule;
    private String courseName;
    private String teacherName;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
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

    public ScheduleDTO(){

    }

    public static final class ScheduleDTOBuilder {
        private ScheduleDTO instance;

        public ScheduleDTOBuilder build() {
            ScheduleDTOBuilder builder = new ScheduleDTOBuilder();
            builder.instance = new ScheduleDTO();
            return builder;
        }

        public ScheduleDTOBuilder withSchedule(Schedule schedule){
            this.instance.setSchedule(schedule);
            return this;
        }

        public ScheduleDTOBuilder withCourseName(String courseName){
            this.instance.setCourseName(courseName);
            return this;
        }

        public ScheduleDTOBuilder withTeacherName(String teacherName){
            this.instance.setTeacherName(teacherName);
            return this;
        }

        public ScheduleDTO get(){
            return this.instance;
        }
    }
}
