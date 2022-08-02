package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ToAcess{
	
public static void main(String[] args) throws SQLException {
	//step 1:Register to DB
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");

	//step 2:connect to mySQL
	Statement statement = connection.createStatement();

	//step 3:SQL statement\query
	String query="select * from project";
	
	//step 4:Execute the query
	ResultSet result = statement.executeQuery(query);
	while (result.next()) {
		System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3)+"  "+result.getString(4)+"  "+result.getString(5)+"  "+result.getString(6));
	}

	//step 5: Terminate DB connection
	connection.close();
}
}
