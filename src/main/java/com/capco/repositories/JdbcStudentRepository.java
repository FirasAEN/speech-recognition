package com.capco.repositories;

import com.capco.entities.Major;
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

    @Override
    public Student getStudentDetails(long id) {
        Log.debug("Get details of student of id {}", id);
        String query = "SELECT stu.first_name, stu.last_name, stu.registration_year as year, stu.average_gpa as gpa, maj.name as major_name FROM Student as stu\n" +
                        "INNER JOIN Major as maj\n" +
                        "ON stu.major_id = maj.id\n" +
                        "WHERE stu.id = ?";
        Student student = jdbc.queryForObject(query, new StudentDetailsRowMapper(), id);
        student.setId(id);
        return student;
    }

    private final static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = Long.parseLong(resultSet.getString("id"));
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            return new Student(id, firstName, lastName);
        }
    }

    private final static class StudentDetailsRowMapper implements  RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            long year = resultSet.getLong("year");
            float gpa = resultSet.getFloat("gpa");
            String majorName = resultSet.getString("major_name");

            Major major = new Major(majorName);
            Student student = new Student(firstName, lastName);
            student.setMajor(major);
            student.setRegistrationYear(year);
            student.setAverageGPA(gpa);
            return student;
        }
    }
}
