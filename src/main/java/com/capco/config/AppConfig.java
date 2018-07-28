package com.capco.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Firas on 7/28/2018.
 */
@Configuration
@ComponentScan(basePackages = {"com.capco"})
@PropertySource({"classpath:db.properties"})
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    public JdbcOperations jdbc(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.user"));
        dataSource.setPassword(env.getProperty("db.pass"));
        return dataSource;
    }
}
