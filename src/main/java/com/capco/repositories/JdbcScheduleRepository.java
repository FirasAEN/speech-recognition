package com.capco.repositories;

import com.capco.entities.Schedule;
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
 * Created by Firas on 8/5/2018.
 */
@Repository
public class JdbcScheduleRepository implements ScheduleRepository {
    private final static Logger Log = LoggerFactory.getLogger(JdbcScheduleRepository.class);
    private final JdbcOperations jdbc;

    @Autowired
    public JdbcScheduleRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Schedule> getSchedules(long courseId) {
        Log.debug("Get schedules for course of id {}", courseId);
        String query = "SELECT sc.from_hour, sc.to_hour, sc.day, sc.room from Course as cou\n" +
                "INNER JOIN Schedule as sc\n" +
                "on cou.id = sc.course_id\n" +
                "WHERE cou.id = ?";
        return jdbc.query(query, new CourseScheduleRowMapper(), courseId);
    }

    private static final class CourseScheduleRowMapper implements RowMapper<Schedule> {
        @Override
        public Schedule mapRow(ResultSet resultSet, int i) throws SQLException {
            String from = resultSet.getString("from_hour");
            String to = resultSet.getString("to_hour");
            String room = resultSet.getString("room");
            String day = resultSet.getString("day");
            return new Schedule(from, to, room, day);
        }
    }
}
