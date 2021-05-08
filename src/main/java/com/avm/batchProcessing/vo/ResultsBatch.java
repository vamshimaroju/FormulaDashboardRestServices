package com.avm.batchProcessing.vo;

import lombok.Data;

@Data
public class ResultsBatch {
    private String resultId;
    private String raceId;
    private String driverId;
    private String constructorId;
    private String number;
    private String grid;
    private String position;
    private String positionText;
    private String positionOrder;
    private String points;
    private String laps;
    private String time;
    private String milliseconds;
    private String fastestLap;
    private String rank;
    private String fastestLapTime;
    private String fastestLapSpeed;
    private String statusId;

}
