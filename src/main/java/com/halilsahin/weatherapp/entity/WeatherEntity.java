package com.halilsahin.weatherapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.apache.camel.dataformat.bindy.annotation.*;

import java.sql.Timestamp;
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
    @DataField(pos = 1, columnName = "DateTime")
    private long dt;
    @Link private Sys sys;
    private int timezone;
    private int id;
    @DataField(pos = 3, columnName = "city")
    private String name;
    private int cod;

    public WeatherEntity(Main main, Sys sys, long dt, String name) {
        this.main = main;
        this.sys = sys;
        this.dt = dt;
        this.name = name;
    }
}