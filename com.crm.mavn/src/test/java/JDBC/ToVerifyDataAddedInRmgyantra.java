package JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ToVerifyDataAddedInRmgyantra {

	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		DriverManager.getConnection("");
		

	}

}
