# weather-simulate

## About

This is a Java application which generates the weather data for a set of future dates based on the historical data provided
We feed-in a set of input locations in the location.txt file, provide the historical data (*weather details for the location for the 12 months of an year*), the application will generate a set of output data for the given *Start Date* and *Number of Days*

For example, if we have the location Sydney in the input file 'locations.txt' , then for the input arguments *start-date '06/02/2018'* and *NumberOfDays '3'*, the output will be generated as below

```
Sydney|33.86,151.20,20|2018-06-02 09:30:00|Sunny|13.45|1034.28|59.41
Sydney|33.86,151.20,20|2018-06-03 09:30:00|Sunny|15.23|1025.18|68.34
Sydney|33.86,151.20,20|2018-06-04 09:30:00|Rain|15.43|1020.92|75.13
```

## How it works

*weather-simulate* application makes use of the [Auto-Regressive Integrated Moving Average (ARIMA)](https://en.wikipedia.org/wiki/Autoregressive_integrated_moving_average) algorithm for timeseries data prediction. 
We prepare a set of input csv files for all the months for a location before the application could start predicting the outputs. 
When the application is executed with a start date and a duration argument, the required csv file data are loaded and given as input to the ARIMA implementation along with the number of forecast results required. 
The result is then printed to the output file location mentioned at execution


## Input
As with any prediction application, the input data preparation is critical here as well. The more the input data fed to the model, the more accurate the result it generates. 
Hence data preparation is an important part here

The input data used in this application is downloaded from [The Bureau of Meteorology, Govt. of Australia ](http://www.bom.gov.au/climate/dwo/) 

Presently the input data has been prepared for the following [locations](https://github.com/shankar-g4/weather-simulate/blob/master/weathersimulate/src/main/resources/locations.txt) for the time 09.30 :
```
Adelaide
Brisbane
Canberra
Gold Coast
Melbourne
Perth
Sydney
```

## Prerequisites
```
JDK 1.7 or better
Maven 4 or better
```
## How to Use
This application is created as a maven project


The executable jar [weathersimulate-0.0.1-SNAPSHOT-jar-with-dependencies.jar](https://github.com/shankar-g4/weather-simulate/tree/master/weathersimulate/target) has been created already using maven *clean install*

Usage:
```
 java -cp weathersimulate-0.0.1-SNAPSHOT-jar-with-dependencies.jar Main <StartDate> <NumberOfDays> <output/file/path>
```

Example usage :
```
 java -cp weathersimulate-0.0.1-SNAPSHOT-jar-with-dependencies.jar Main 2018-07-20 10 output.txt
```
However if you want to make any changes to the application, you can create the executable by following the commands below

Use the following Command from the command line
<pre>
<b>mvn clean install</b>
</pre>
or,

if you are using Eclipse IDE then,
<pre>
<b>Right Click on the project</b>

<b>Select Run As > Maven build...</b>

<b>Type</b> clean install <b>in the Goals Text-box</b>
</pre>
An executable jar file will be created at [weather-simulate/tree/master/weathersimulate/target](https://github.com/shankar-g4/weather-simulate/tree/master/weathersimulate/target)

## Dependencies

The application has the following [dependencies](https://github.com/shankar-g4/weather-simulate/blob/master/weathersimulate/pom.xml):
```
JUnit 4.12
WorkdayTimeseriesForecast 1.1.1
JacksonCore 2.6.3
OpenCSV 3.3
```

## Authors

Shankar G

email : shankar.g4@tcs.com


## License
[![WM](https://upload.wikimedia.org/wikipedia/commons/f/f8/License_icon-mit-88x31-2.svg)](https://github.com/shankar-g4/weather-simulate/blob/master/LICENSE)

Licensed under MIT

Copyright (c) 2017 shankar-g4
