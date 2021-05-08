package com.avm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Constructors {
    
    @Id
    @Column(name="constructor_id")
    private Long constructorId;
    
    @Column(name="constructor_ref")
    private String constructorRef;
    private String name;
    private String nationality;
    private String url;
}
