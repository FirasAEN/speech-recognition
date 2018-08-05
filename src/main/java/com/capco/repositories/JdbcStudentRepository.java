package com.capco.repositories;

import com.capco.entities.Student;
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
 * Created by Firas on 7/28/2018.
 */
@Repository
public class JdbcStudentRepository implements StudentRepository {
    private final static Logger  Log = LoggerFactory.getLogger(JdbcStudentRepository.class);
    private final JdbcOperations jdbc;

    @Autowired
    public JdbcStudentRepository(JdbcOperations jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public List<Student> getAllStudents() {
        Log.debug("Getting All students");
        String query = "SELECT * FROM Student";
        List<Student> result = jdbc.query(query, new StudentRowMapper());
        return result;
    }

    @Override
    public Student getStudentById(long id) {
        Log.debug("Get student of id {}", id);
        String query = "SELECT * FROM Student where id=?";
        return jdbc.queryForObject(query, new StudentRowMapper(), id);
    }

    private final static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = Long.parseLong(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Student(id, name);
        }
    }
}
