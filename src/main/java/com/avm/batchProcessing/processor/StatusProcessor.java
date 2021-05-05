package com.avm.batchProcessing.processor;


import com.avm.batchProcessing.vo.StatusBatch;
import com.avm.entities.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class StatusProcessor implements ItemProcessor<StatusBatch,Status>{
    
    private static final Logger log = LoggerFactory.getLogger(StatusProcessor.class);

    @Override
    public Status process(final StatusBatch statusBatch) throws Exception{
        final String statusId = statusBatch.getStatusId();
        final String status = statusBatch.getStatus();
        Status statusObj = null;
        try{
             statusObj = new Status(Long.parseLong(statusId),status);
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        log.info("Converting ( "+statusBatch+" ) into ( "+statusObj+" )");
        return statusObj;
        
    }

}
