package com.avm.batchProcessing.processor;

import com.avm.batchProcessing.vo.SeasonsBatch;
import com.avm.entities.Seasons;

import org.springframework.batch.item.ItemProcessor;

public class SeasonsProcessor implements ItemProcessor<SeasonsBatch,Seasons> {

    @Override
    public Seasons process(SeasonsBatch item) throws Exception {
        // TODO Auto-generated method stub
        Seasons seasonObj = null;
        try {
            final Long year = Long.parseLong(item.getYear());
            final String url = item.getUrl();

            seasonObj = new Seasons(year, url);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return seasonObj;
    }
    
    
}
