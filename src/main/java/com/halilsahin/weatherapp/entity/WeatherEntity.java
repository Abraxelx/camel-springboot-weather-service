package com.halilsahin.weatherapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.apache.camel.dataformat.bindy.annotation.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
public class WeatherEntity {

    private Coord coord;
    private List<Weather> weather;
    private String base;
    @Link private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    @DataField(pos = 1, pattern = "MM/dd/yyy hh:mm:ss a", columnName = "DateTime")
    private Date dateTime;
    private long dt;
    @Link private Sys sys;
    private int timezone;
    private int id;
    @DataField(pos = 3, columnName = "city")
    private String name;
    private int cod;
}