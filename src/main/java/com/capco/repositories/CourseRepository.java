package com.capco.repositories;

import com.capco.entities.Course;

import java.util.List;

/**
 * Created by Firas on 7/30/2018.
 */
public interface CourseRepository {
    List<Course> getAllCourses();

    Course getCourseById(long id);

    List<Course> getCoursesForStudent(long studentId);
}
