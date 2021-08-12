package com.halilsahin.weatherapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Data
@NoArgsConstructor
@AllArgsConstructor
@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
