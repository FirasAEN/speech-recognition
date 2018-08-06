package com.capco.resources;

import com.capco.entities.Course;
import com.capco.entities.Student;
import com.capco.services.CourseService;
import com.capco.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Firas on 7/30/2018.
 */
@CrossOrigin(origins = "http://localhost:8050")
@RestController
public class CourseResource {
    private static final Logger Log = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping(
            value = "/courses/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Course>> getAllCourses(){
        Log.debug("REST request to get all courses");
        List<Course> courses = courseService.getCourses();
        return ResponseEntity.ok(courses);
    }
}
