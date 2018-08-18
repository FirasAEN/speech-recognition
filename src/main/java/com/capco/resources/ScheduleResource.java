package com.capco.resources;

import com.capco.dto.ScheduleDTO;
import com.capco.entities.Course;
import com.capco.services.CourseService;
import com.capco.services.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Firas on 8/18/2018.
 */
@CrossOrigin(origins = "http://localhost:8050")
@RestController
public class ScheduleResource {
    private static final Logger Log = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(
            value = "/schedules/{studentId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ScheduleDTO>> getAllSchedules(@PathVariable(value = "studentId") long id){
        Log.debug("REST request to get all schedules for student of id {}", id);
        List<ScheduleDTO> schedules = scheduleService.getSchedules(id);
        return ResponseEntity.ok(schedules);
    }
}
