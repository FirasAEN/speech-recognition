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

    private final static class CourseRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = Long.parseLong(resultSet.getString("id"));
            String name = resultSet.getString("course");
            return new Course(id, name);
        }
    }
}
