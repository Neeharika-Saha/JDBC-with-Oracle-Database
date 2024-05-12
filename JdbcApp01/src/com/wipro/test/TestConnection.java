package com.wipro.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {
		Connection con;   //  ctrl+space+enter -> add corresponding new package or simply write ctrl+o
		/* Step #1: Load and Register Driver */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Tiger");
			if(con!=null) {
				System.out.println("Connection Established!!!");
			}
			else {
				System.out.println("Connection Failed!!!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/*  // By decompiler we can see the source code by .class file 
		  	oracle.jdbc.driver.OracleDriver driver = new oracle.jdbc.driver.OracleDriver();
		 	DriverManager.registerDriver(driver);
		 	// It is internally given in odbc jar file provided by Oracle DB.
		 	// Bad Approach because object creation is a costly operation.
		 	// We can tell "oracle.jdbc.OracleDriver" instead of writing "oracle.jdbc.driver.OracleDriver", because it is present in jdbc folder/package also in driver folder/package
		 */
		
	}

}
