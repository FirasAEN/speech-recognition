package com.capco.services;

import com.capco.dto.StudentDTO;
import com.capco.entities.Course;
import com.capco.entities.Student;
import com.capco.repositories.CourseRepository;
import com.capco.repositories.ScheduleRepository;
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
    private final CourseRepository coursesRepository;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          CourseRepository courseRepository,
                          ScheduleRepository scheduleRepository){
        this.studentRepository = studentRepository;
        this.coursesRepository = courseRepository;
        this.scheduleRepository = scheduleRepository;
    }


    public StudentDTO getStudentDTOById(long id){
        Log.debug("Request to get student of id {}", id);
        return new StudentDTO(studentRepository.getStudentById(id));
    }

    public Student getStudentInfoById(long id){
        Log.debug("Request to get student of id {}", id);
        return studentRepository.getStudentDetails(id);
    }

    public Student getStudentWithCourses(long studentId){
        Log.debug("Request to get courses and schedules for student of studentId {}", studentId);
        Student student = studentRepository.getStudentDetails(studentId);
        List<Course> courses = coursesRepository.getCoursesForStudent(studentId);
        courses.forEach(course -> {
            course.setSchedules(scheduleRepository.getSchedules(course.getId()));
        });
        student.setCourses(courses);
        return student;
    }
}
