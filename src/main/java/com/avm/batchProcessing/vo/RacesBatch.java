package com.avm.batchProcessing.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RacesBatch {
    private String raceId;
    private String year;
    private String round;
    private String circuitId;
    private String name;
    private String date;
    private String time;
    private String url;
}
