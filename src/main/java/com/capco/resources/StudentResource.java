package com.capco.resources;

import com.capco.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Firas on 7/28/2018.
 */
@RestController
public class StudentResource {
    private static final Logger Log = LoggerFactory.getLogger(StudentResource.class);


    @RequestMapping(
            value = "/Student",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Student> test(){
        Log.info("Testing resource");
        Student rida = new Student("Rida AEN");
        return ResponseEntity.ok(rida);
    }
}
