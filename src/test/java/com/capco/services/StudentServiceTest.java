package com.capco.services;

import com.capco.entities.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Firas on 8/5/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.capco.config.AppConfig.class)
public class StudentServiceTest {
    private static Logger Log = LoggerFactory.getLogger(StudentServiceTest.class);

    @Autowired
    StudentService studentService;

    @Test
    public void getCoursesByStudentId() throws Exception {
        Student student = studentService.getStudentWithCourses(1);
        Log.debug(student.toString());
        assertEquals(student.getCourses().size(), 4);
    }

}