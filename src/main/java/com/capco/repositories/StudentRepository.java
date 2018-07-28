package com.capco.repositories;

import com.capco.entities.Student;

import java.util.List;

/**
 * Created by Firas on 7/28/2018.
 */
public interface StudentRepository {
    List<Student> getAllStudents();

    Student getStudentById();
}
