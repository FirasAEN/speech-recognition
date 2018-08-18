package com.capco.repositories;

import com.capco.entities.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Firas on 8/5/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.capco.config.AppConfig.class)
public class JdbcStudentRepositoryTest {

    @Autowired
    JdbcStudentRepository repo;

    @Test
    public void getStudentWithMajor() throws Exception {
        Student student = repo.getStudentDetails(1);
        assertEquals(student.getId(), 1);
    }

}