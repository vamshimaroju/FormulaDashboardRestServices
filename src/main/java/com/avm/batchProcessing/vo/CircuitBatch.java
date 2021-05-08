package com.avm.batchProcessing.vo;

import lombok.Data;

@Data
public class CircuitBatch {
    private String circuitId;
    private String circuitRef;
    private String name;
    private String location;
    private String country;
    private String lat;
    private String lng;
    private String alt;
    private String url;
}
