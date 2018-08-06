package com.capco.repositories;

import com.capco.entities.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Firas on 7/30/2018.
 */
@Repository
public class JdbcCourseRepository implements CourseRepository {
    private static final Logger Log = LoggerFactory.getLogger(JdbcCourseRepository.class);
    private final JdbcOperations jdbc;

    @Autowired
    public JdbcCourseRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Course> getAllCourses() {
        Log.debug("Getting all courses");
        String sql = "SELECT * FROM Course";
        List<Course> result = jdbc.query(sql, new CourseRowMapper());
        return result;
    }

    @Override
    public Course getCourseById(long id) {
        return null;
    }

    @Override
    public List<Course> getCoursesForStudent(long studentId) {
        Log.debug("Get courses enrolled in by student of id {}", studentId);
        String query = "SELECT stu.name as student_name, cou.course, cou.id as course_id\n" +
                "from Student as stu\n" +
                "  INNER JOIN Course as cou\n" +
                "  INNER JOIN Student_Course\n" +
                "    ON Student_Course.student_id = stu.id\n" +
                "       AND Student_Course.course_id = cou.id\n" +
                "WHERE stu.id = ?";
        return jdbc.query(query, new CourseStudentRowMapper(), studentId);
    }

    private final static class CourseRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = Long.parseLong(resultSet.getString("id"));
            String name = resultSet.getString("course");
            return new Course(id, name);
        }
    }

    private static final class CourseStudentRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet resultSet, int i) throws SQLException {
            Long id = Long.valueOf(resultSet.getString("course_id"));
            String courseName = resultSet.getString("course");
            return new Course(id, courseName);
        }
    }
}
