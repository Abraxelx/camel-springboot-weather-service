package com.halilsahin.weatherapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Main {
    @DataField(pos = 4, columnName = "temp")
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
}