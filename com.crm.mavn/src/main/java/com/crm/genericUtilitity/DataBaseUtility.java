package com.crm.genericUtilitity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import com.mysql.jdbc.Driver;
/**
 * 
 * @author 91900
 *
 */
public class DataBaseUtility {
static Driver driverRef;
static Connection connection;
static ResultSet result;
/**
 * This method is used to connect the DataBase
 * @param DBname
 */
public void connectToDb(String DBname) {
	try {
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		connection=DriverManager.getConnection(Iconstants.DBurl+DBname,Iconstants.DBUserName,Iconstants.DBPassword);
			} catch (Exception e) {
		e.printStackTrace();
	}
}
/**
 * This method is to close the data base connectivity
 */
public void closeDB() {
	try {
		connection.close();
	} catch (Exception e) {
		System.out.println("UNABLE TO CLOSE CONNECTION");
	}
}
	/**
	 * This method is to fetch data from DataBase
	 * @param query
	 * @param columnNum
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean execuiteQuery(String query,int columnNum,String expectedData) throws SQLException {
		result = connection.createStatement().executeQuery(query);
		boolean flag=false;
		while (result.next()) {
			if (result.getString(columnNum).equals(expectedData)) {
				flag=true;
				break;
			}
			
		}
		if (flag) {
			System.out.println("Data is Present");
			return flag;
		}
		else {
			System.out.println("Data is not Present");
			return flag;
		}
		
	}
	/**
	 * This method is to update DB
	 * @param query
	 * @throws SQLException
	 */
	public void executeUpdate(String query) throws SQLException {
		int res= connection.createStatement().executeUpdate(query);
		if (res==1) {
			System.out.println("Data is Updated");
		}
		else {
			System.out.println("Data is Not Update");
		}
		
	}
}

