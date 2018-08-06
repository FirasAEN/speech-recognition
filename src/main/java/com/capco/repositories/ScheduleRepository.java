package com.capco.repositories;

import com.capco.entities.Schedule;

import java.util.List;

/**
 * Created by Firas on 8/5/2018.
 */
public interface ScheduleRepository {
    List<Schedule> getSchedules(long courseId);
}
