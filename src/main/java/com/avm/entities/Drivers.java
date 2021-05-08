package com.avm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drivers {
    
    @Id
    @Column(name="driver_id")
    private Long driverId;

    @Column(name="driver_ref")
    private String driverRef;

    @Column(name="driver_number")
    private Integer driverNumber;

    @Column(name="driver_code")
    private String driverCode;

    private String forename;
    private String surname;
    private String dob;
    private String nationality;
    private String url;
}
