package com.avm.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor

@ToString
public class Races {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="race_id")
    private Long raceId;
    private Long year;
    private long round;
    @Column(name="circuit_id")
    private long circuitId;
    private String name;
    private Date date;
    private String time;
    private String url;
    public Races(Long raceId, Long year, long round, long circuitId, String name, LocalDate date, String time, String url) {
        this.raceId = raceId;
        this.year = year;
        this.round = round;
        this.circuitId = circuitId;
        this.name = name;
        this.date = Optional.ofNullable(date).map(Date::valueOf).orElse(null);
        this.time = time;
        this.url = url;
    }

    
}