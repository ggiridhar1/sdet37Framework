package com.crm.genericUtilitity;
import java.sql.Time;
import java.util.Date;
import java.util.Random;

import org.asynchttpclient.netty.ws.NettyWebSocket;

public class JavaUtility {
	/**
	 * This method is to get random number
	 * @return
	 */
public int getRandomNum() {
	Random random=new Random();
	int randNum = random.nextInt();
	return randNum;
}
/**
 * This method is to get system date and time
 * @return
 */
public String getSystemDate() {
	Date date=new Date();
	String datetime = date.toString();
	return datetime;
}
/**
 * This method is to format the date to user requirements
 * @return
 */
public String getDateInFormat() {
	Date datee=new Date();
	String dateTime = datee.toString();
	String[] datearr = dateTime.split(" ");
	
	String month = datearr[1];
	String year = datearr[5];
	String date = datearr[2];
	String day = datearr[0];
	String Time = datearr[3];
	
	String finalformat=Time+" "+date+" "+day+" "+month+" "+year;
	System.out.println(finalformat);
	return finalformat;
}
}
