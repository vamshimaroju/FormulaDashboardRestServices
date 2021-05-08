package com.avm.batchProcessing.vo;

import lombok.Data;

@Data
public class PitStopsBatch {
    private String raceId;
    private String driverId;
    private String stop;
    private String lap;
    private String time;
    private String duration;
    private String milliseconds;

}
