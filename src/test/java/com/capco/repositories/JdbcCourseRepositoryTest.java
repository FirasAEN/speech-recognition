package com.capco.repositories;

import com.capco.entities.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Firas on 8/5/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.capco.config.AppConfig.class)
public class JdbcCourseRepositoryTest {

    @Autowired
    JdbcCourseRepository repo;

    @Test
    public void getCoursesForStudent() throws Exception {
        List<Course> courses = repo.getCoursesForStudent(1);
        assertEquals(courses.size(), 2);
    }

}