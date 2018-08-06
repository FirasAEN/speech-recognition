package com.capco.services;

import com.capco.entities.Course;
import com.capco.entities.Student;
import com.capco.repositories.CourseRepository;
import com.capco.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Firas on 7/30/2018.
 */
@Service
public class CourseService {
    private final static Logger Log = LoggerFactory.getLogger(StudentService.class);
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses(){
        Log.debug("Request to get all courses");
        List<Course> allCourses = courseRepository.getAllCourses();
        return allCourses;
    }
}
