package com.capco.repositories;

import com.capco.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Firas on 7/28/2018.
 */
@Repository
public class JdbcStudentRepository implements StudentRepository {
    private final static Logger  Log = LoggerFactory.getLogger(JdbcStudentRepository.class);
    private final JdbcOperations jdbc;

    @Autowired
    public JdbcStudentRepository(JdbcOperations jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public List<Student> getAllStudents() {
        Log.debug("Getting All students");
        return null;
    }

    @Override
    public Student getStudentById() {
        return null;
    }
}
