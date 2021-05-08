package com.avm.batchProcessing.processor;

import com.avm.batchProcessing.vo.ConstructorStandingBatch;
import com.avm.entities.ConstructorStandings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ConstructorStandingProcessor implements ItemProcessor<ConstructorStandingBatch,ConstructorStandings>{
    private static final Logger log = LoggerFactory.getLogger(ConstructorStandingProcessor.class);

    @Override
    public ConstructorStandings process(final ConstructorStandingBatch constStndBatch) throws Exception{
        
        ConstructorStandings constStndObj = null;
        try{
            final Long constructorStandingId = Long.parseLong(constStndBatch.getConstructorStandingsId());
            final Long raceId = Long.parseLong(constStndBatch.getRaceId());
            final Long constructorId = Long.parseLong(constStndBatch.getConstructorId());
            final Integer points = Integer.parseInt(constStndBatch.getPoints());
            final Integer position = Integer.parseInt(constStndBatch.getPosition());
            final Integer positionText = Integer.parseInt(constStndBatch.getPositionText());
            final Integer wins = Integer.parseInt(constStndBatch.getWins());

            constStndObj = new ConstructorStandings(constructorStandingId, raceId, constructorId, points, position, positionText, wins);
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        log.info("Converting ( "+constStndBatch+" ) into ( "+constStndObj+" )");
        return constStndObj;
        
    }
}
