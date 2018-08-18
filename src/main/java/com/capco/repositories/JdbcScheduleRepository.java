package com.capco.repositories;

import com.capco.dto.ScheduleDTO;
import com.capco.entities.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowCallbackHandler;
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

    public List<ScheduleDTO> getSchedulesForStudent(long studentId){
        Log.debug("Get all schedules for student of id {}", studentId);
        String query = "SELECT cou.course_name, cou.teacher_name, sc.from_hour, sc.to_hour, sc.room, sc.day\n" +
                "from Course as cou\n" +
                "  INNER JOIN Student as stu\n" +
                "  INNER JOIN Student_Course\n" +
                "  INNER JOIN Schedule as sc\n" +
                "  INNER JOIN Major as maj\n" +
                "    ON Student_Course.student_id = stu.id\n" +
                "       AND Student_Course.course_id = cou.id\n" +
                "       AND sc.course_id = cou.id\n" +
                "       AND stu.major_id = maj.id\n" +
                "WHERE stu.id = ?";
        return jdbc.query(query, new ScheduleDTORowMapper(), studentId);
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

    private class ScheduleDTORowMapper implements RowMapper<ScheduleDTO> {
        @Override
        public ScheduleDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            String from = resultSet.getString("from_hour");
            String to = resultSet.getString("to_hour");
            String room = resultSet.getString("room");
            String day = resultSet.getString("day");
            String courseName = resultSet.getString("course_name");
            String teacherName = resultSet.getString("teacher_name");

            Schedule schedule = new Schedule(from, to, room, day);
            ScheduleDTO.ScheduleDTOBuilder builder = new ScheduleDTO.ScheduleDTOBuilder();
            ScheduleDTO scheduleDTO = builder.build()
                    .withSchedule(schedule)
                    .withCourseName(courseName)
                    .withTeacherName(teacherName)
                    .get();

            return scheduleDTO;
        }
    }
}
