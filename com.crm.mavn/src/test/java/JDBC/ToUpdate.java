package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToUpdate {
public static void main(String[] args) throws SQLException {
 //step 1:Register to Database
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	
	//step 2:connect to mySQL
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	
	//step 3:execute the query
    Statement statement = connection.createStatement();
    String query= "insert into Project values('TY_PROJ_004','V.S.Giridhar','07/11/2022','j2ee','completed','0')";
    
    //step 4: execute the query
    int Result = statement.executeUpdate(query);
    if (Result==1) {
		System.out.println("Project is created");
	}
    else {
		System.out.println("Project is not created");
	}
    //Terminate connection
    connection.close();
	}

}
