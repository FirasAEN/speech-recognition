package com.capco.services;

import com.capco.entities.Student;
import com.capco.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Firas on 7/28/2018.
 */
@Service
public class StudentService {
    private final static Logger Log = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        Log.debug("Request to get all students");
        List<Student> allStudents = studentRepository.getAllStudents();
        return allStudents;
    }
}
