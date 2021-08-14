# Apache Camel Springboot Weather Service

The purpose of this application is to write only the specified parts of the data it receives from the weather application, </br>
which is one of the components of Apache Camel, to a csv file.
</br>
The application gets its api support from:</br>
<a href="https://openweathermap.org/">openweathermap.org</a></br>

## Special Informations
The application gets new values every hour from the city specified in</br>
the variable <b style="font-family:verdana; color:blue;">{weather.city}</b> specified in the <b>application.properties</b> file and saves them in the <b>weatherData.csv</b> file in the:</br>
<b>files/output</b> folder.

# How To Run
After installing the application on a spring boot platform, do a maven clean install. Then run the WeatherApplication.class class and the application will run. You can follow the logs throwed by the application on the terminal screen.
