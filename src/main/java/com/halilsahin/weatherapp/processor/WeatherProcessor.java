package com.halilsahin.weatherapp.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherProcessor implements Processor {
    Logger logger = LoggerFactory.getLogger(WeatherProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("Executing Weather Processor");
    }
}
