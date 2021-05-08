package com.avm.batchProcessing.processor;

import com.avm.entities.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport{
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution){
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("!!! JOB FINISHED! Time to verify the result");
        }
    //     jdbcTemplate.query("SELECT status_id||'',status FROM status",
    //     (rs, row) -> new Status(
    //       Long.parseLong(rs.getString(1)),
    //       rs.getString(2))
    //   ).forEach(status -> log.info("Found <" + status + "> in the database."));
        
    }
}
