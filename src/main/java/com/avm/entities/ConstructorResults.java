package com.avm.entities;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConstructorResults {

    @Id
    @Column(name="constructor_results_id")
    private Long constructorResultId;

    @Column(name="race_id")
    private Long raceId;
    
    @Column(name="constructor_id")
    private Long constructorId;

    private Integer points;
    private String status;

    
}
