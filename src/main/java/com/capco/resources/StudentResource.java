package com.capco.resources;

import com.capco.entities.Student;
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
 * Created by Firas on 7/28/2018.
 */
@CrossOrigin(origins = "http://localhost:8050")
@RestController
public class StudentResource {
    private static final Logger Log = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(
            value = "/students/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Student>> getAllStudents(){
        Log.debug("REST request to get all students");
        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }
}
