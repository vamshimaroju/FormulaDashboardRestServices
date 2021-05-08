package com.avm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Results {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="result_id")
    private Long resultId;

    @Column(name="race_id")
    private Long raceId;

    @Column(name="driver_id")
    private Long driverId;
    
    @Column(name="constructor_id")
    private Long constructorId;
    
    @Column(name="driver_number")
    private Integer driverNumber;

    private Integer grid;
    private Integer position;
    private Integer positionOrder;
    private Integer points;
    private Integer laps;
    private String time;
    private Long milliseconds;
    @Column(name="fastest_lap_time")
    private String fastestLapTime;
    @Column(name="fastest_lap_speed")
    private Long fastestLapSpeed;
    @Column(name="status_id")
    private Long statusId;
    
}
