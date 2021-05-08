package com.avm.batchProcessing.processor;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.WeekFields;

import com.avm.batchProcessing.vo.RacesBatch;
import com.avm.entities.Races;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class RaceProcessor implements ItemProcessor<RacesBatch,Races>{
    private static final Logger log = LoggerFactory.getLogger(RaceProcessor.class);

    @Override
    public Races process(final RacesBatch racesBatch) throws Exception{
        Races races = null;
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                                        .appendPattern("yyyy-MM-dd")
                                        .parseDefaulting(WeekFields.ISO.dayOfWeek(), DayOfWeek.SUNDAY.getValue())
                                        .toFormatter();
    try{
        final Long raceId = Long.parseLong(racesBatch.getRaceId());
        final Long year = Long.parseLong(racesBatch.getYear());
        final Long round = Long.parseLong(racesBatch.getRound());
        final Long circuitId = Long.parseLong(racesBatch.getCircuitId());
        final String name = racesBatch.getName();
        final LocalDate date = LocalDate.parse(racesBatch.getDate(),formatter);
        final String time = racesBatch.getTime();
        final String url = racesBatch.getUrl();
        
        races = new Races(raceId, year, round, circuitId, name, date, time, url);
        log.info("Races Records :: {}",races);
    }catch(Exception e){
        e.printStackTrace();
        log.error("error in {}",this.getClass().getSimpleName());
    }
        return races;
        
    }

    public static void main(String[] args) {
        String dt = "2018-05-15";
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var date = LocalDate.parse(dt,formatter);
        System.out.println(date);
    }
}
