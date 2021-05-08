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
public class Circuits {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="circuit_id")
    private Long circuitId;

    @Column(name="circuit_ref")
    private String circuitRef;
    private String name;
    private String location;
    private String country;
    private String latitude;
    private String longitude;
    private String altitude;
    private String url;
}
