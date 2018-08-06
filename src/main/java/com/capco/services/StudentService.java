package com.capco.services;

import com.capco.entities.Course;
import com.capco.entities.Schedule;
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

    public List<Student> getStudents(){
        Log.debug("Request to get all students");
        List<Student> allStudents = studentRepository.getAllStudents();
        return allStudents;
    }

    public Student getById(long id){
        Log.debug("Request to get student of id {}", id);
        return studentRepository.getStudentById(id);
    }

    public Student getCoursesByStudentId(long studentId){
        Log.debug("Request to get courses and schedules for student of studentId {}", studentId);
        Student student = studentRepository.getStudentWithMajor(studentId);
        List<Course> courses = coursesRepository.getCoursesForStudent(studentId);
        courses.forEach(course -> {
            course.setSchedules(scheduleRepository.getSchedules(course.getId()));
        });
        student.setCourses(courses);
        return student;
    }
}