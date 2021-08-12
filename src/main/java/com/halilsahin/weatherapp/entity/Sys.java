package com.halilsahin.weatherapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sys {
    private int type;
    private int id;
    @DataField(pos = 2, columnName = "Country")
    private String country;
    private long sunrise;
    private long sunset;
}
