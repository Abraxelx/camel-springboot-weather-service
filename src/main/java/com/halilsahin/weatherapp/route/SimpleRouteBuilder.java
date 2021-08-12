package com.halilsahin.weatherapp.route;

import com.halilsahin.weatherapp.entity.WeatherEntity;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.BindyType;
import org.springframework.stereotype.Component;


@Component
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(WeatherEntity.class);


        from("weather:foo?location={{weather.city}}&units=metric&appid={{weather.appId}}")
                .convertBodyTo(String.class)
                .unmarshal(jacksonDataFormat)
                .marshal().bindy(BindyType.Csv, WeatherEntity.class)
                .to("file:files/output?fileName=weatherData.csv")
                .log("{{create.csv.message}}")
                .log("${body}");
    }
}