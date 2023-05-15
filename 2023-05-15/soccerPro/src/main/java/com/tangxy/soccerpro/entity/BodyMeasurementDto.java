package com.tangxy.soccerpro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BodyMeasurementDto {
    private long id;
    private String userName;
    private double weight;
    private double height;
    private double speed100m;
    private double speed1000m;
    private String vitalcapacity;
    private String kickspeed;
}
