package com.avm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "laptime")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LapTime {
    
    @Id
    @Column(name="race_id")
    private Long raceId;

    @Column(name="driver_id")
    private Long driverId;

    private Long lap;
    private Integer position;
    private String time;
private String milliseconds;
}
