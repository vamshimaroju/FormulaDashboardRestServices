package com.avm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CollectionId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverStandings {
    
    @Id
    @Column(name="driver_standings_id")
    private Long driverStandingsId;

    @Column(name="race_id")
    private Long raceId;

    @Column(name="driver_id")
    private Long driverId;

    private Integer points;
    private Integer position;
    private Integer positionText;
    private Integer wins;

}
