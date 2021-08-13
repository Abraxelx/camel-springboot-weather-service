package com.halilsahin.weatherapp.route;

import com.halilsahin.weatherapp.entity.WeatherEntity;
import com.halilsahin.weatherapp.processor.WeatherProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.routepolicy.quartz.CronScheduledRoutePolicy;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


@Component
public class SimpleRouteBuilder extends RouteBuilder {



    @Override
    public void configure() throws Exception {
        CronScheduledRoutePolicy startPolicy = new CronScheduledRoutePolicy();
        startPolicy.setRouteStartTime("0 0 * * * ?"); //Every hours

        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(WeatherEntity.class);


        from("weather:foo?location={{weather.city}}&units=metric&appid={{weather.appId}}")
                .routeId("weather-routing")
                .routePolicy(startPolicy)
                .noAutoStartup()
                .process(new WeatherProcessor())
                .convertBodyTo(String.class)
                .unmarshal(jacksonDataFormat)
                .process(exchange -> {
                    long dt = exchange.getIn().getBody(WeatherEntity.class).getDt();
                    exchange.getIn().getBody(WeatherEntity.class).setDateTime(timestampToDate(dt));
                })
                .marshal().bindy(BindyType.Csv, WeatherEntity.class)
                .to("file:files/output?fileName=weatherData.csv")
                .log("{{create.csv.message}}")
                .log("${body}");

    }



    private Date timestampToDate(long ts){
        Timestamp timestamp = new Timestamp(ts*1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        return calendar.getTime();
    }



}