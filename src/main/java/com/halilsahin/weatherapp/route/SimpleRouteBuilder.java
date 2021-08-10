package com.halilsahin.weatherapp.route;

import com.google.gson.Gson;
import com.halilsahin.weatherapp.entity.WeatherDto;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.dsl.CxfEndpointBuilderFactory;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;


@Component
public class SimpleRouteBuilder extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        DataFormat bind = new BindyCsvDataFormat(WeatherDto.class);
        GsonDataFormat gsonDF = new GsonDataFormat(WeatherDto.class);
        from("weather:foo?location={{weather.city}}&units=metric&appid={{weather.appId}}")
                .unmarshal().json(JsonLibrary.Gson, true)
                .convertBodyTo(String.class)
             //   .marshal().bindy(BindyType.Csv, WeatherDto.class)
                .to("file:files/output?fileName=weatherData.csv")
                .log("{{create.csv.message}}");
       // Thread.sleep(1000*60*60);
    }
}

