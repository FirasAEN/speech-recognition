package com.capco.dto;

import com.capco.entities.Student;

/**
 * Created by Firas on 8/19/2018.
 */
public class StudentDTO {
    private String firstName;
    private String lastName;

    public StudentDTO(Student student){
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
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
}
