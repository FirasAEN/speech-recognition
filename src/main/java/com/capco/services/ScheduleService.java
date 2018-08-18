package com.capco.services;

import com.capco.dto.ScheduleDTO;
import com.capco.repositories.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Firas on 8/18/2018.
 */
@Service
public class ScheduleService {
    final static Logger Log = LoggerFactory.getLogger(ScheduleService.class);

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleDTO> getSchedules(long studentId){
        Log.debug("Request to get all schedules for student {}", studentId);
        return scheduleRepository.getSchedulesForStudent(studentId);

    }

}
