package com.avm.batchProcessing.processor;

import com.avm.batchProcessing.vo.CircuitBatch;
import com.avm.entities.Circuits;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CircuitProcessor implements ItemProcessor<CircuitBatch,Circuits> {
    
    private static final Logger log = LoggerFactory.getLogger(CircuitProcessor.class);

    @Override
    public Circuits process(final CircuitBatch circuitBatch) throws Exception{
        
        Circuits circuitObj = null;
        try{
            final Long circuitId = Long.parseLong(circuitBatch.getCircuitId());
            final String circuitRef = circuitBatch.getCircuitRef();
            final String name = circuitBatch.getName();
            final String location = circuitBatch.getLocation();
            final String country = circuitBatch.getCountry();
            final String latitude = circuitBatch.getLat();
            final String longitude = circuitBatch.getLng();
            final String altitude = circuitBatch.getAlt();
            final String url = circuitBatch.getUrl();

            circuitObj = new Circuits(circuitId, circuitRef, name, location, country, latitude, longitude, altitude, url);                    
             
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        log.info("Converting ( "+circuitBatch+" ) into ( "+circuitObj+" )");
        return circuitObj;
        
    }
}
