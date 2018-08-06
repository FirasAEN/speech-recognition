package com.capco.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Firas on 8/5/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.capco.config.AppConfig.class)
public class JdbcScheduleRepositoryTest {
    @Autowired
    ScheduleRepository repo;

    @Test
    public void getSchedules() throws Exception {
        assertEquals(repo.getSchedules(1).size(), 3);
    }

}