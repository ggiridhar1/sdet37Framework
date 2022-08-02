package com.crm.genericUtilitity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.AddHasCasting;

public interface Iconstants {
String filePathString="./src/test/resources/Auto.properties.txt";
String excelPathString="./src/test/resources/property.xlsx";
String chromeKey="webdriver.chrome.driver";
String chromevalue="./drivers/chromedriver.exe";
String DBurl="jdbc:mysql://localhost:3306";
String DBUserName="root";
String DBPassword="root";
int implicitlyWaitDuration=10;
int explicitlyWaitDuration=10;
}
