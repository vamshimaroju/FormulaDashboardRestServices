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
public class ConstructorStandings {
    
    @Id
    @Column(name="constructor_standings_id")
    private Long constructorStandingId;
    
    @Column(name="race_id")
    private Long raceId;

    @Column(name="constructor_id")
    private Long constructorId;

    @Column(name="points")
    private Integer points;

    private Integer position;

    @Column(name="position_text")
    private Integer positionText;

    private Integer wins;
    
    
    
    
}
