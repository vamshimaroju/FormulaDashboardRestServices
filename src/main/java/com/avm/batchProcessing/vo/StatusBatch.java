package com.avm.batchProcessing.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StatusBatch implements Serializable{
        
    private String statusId;

    private String status;


}
