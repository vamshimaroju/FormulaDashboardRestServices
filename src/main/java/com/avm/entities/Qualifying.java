package com.avm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qualifying {
    
    @Id
    @Column(name="qualify_id")
    private Long qualifyId;

    @Column(name="race_id")
    private Long raceId;

    @Column(name="driver_id")
    private Long driverId;

    @Column(name="constructor_id")
    private Long constructorId;

    @Column(name="driver_number")
    private Integer driverNumber;

    private Integer position;
    private String q1;
    private String q2;
    private String q3;
}
