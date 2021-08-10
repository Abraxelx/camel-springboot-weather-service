package com.halilsahin.weatherapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
public class WeatherDto {
    @DataField(pos = 1, columnName = "temp")
    private String temp;
    @DataField(pos = 2, columnName = "name")
    private String city;
    @DataField(pos = 3, columnName = "country")
    private String country;
    @DataField(pos = 4, columnName = "dt")
    private String receivedTime;
}
