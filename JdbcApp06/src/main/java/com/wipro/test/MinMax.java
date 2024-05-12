// Display minimum / maximum salary from EMP Table of Oracle Database using JDBC. 

package com.wipro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// Step #1: Load and Register Driver
			Class.forName("oracle.jdbc.OracleDriver");
			
			// Step #2: Establish connection between Java Application and Oracle Database
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Tiger");
			
			// Step #3: Create statement object
			if(con!=null) {
				st = con.createStatement();
			}
			
			// Step#4: Send and Execute Query
			if(st!=null) {
				rs = st.executeQuery("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL = (SELECT MIN(SAL) FROM EMP)");
				//rs = st.executeQuery("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL = (SELECT MAX(SAL) FROM EMP)");
			}
			
			System.out.println("EMPNO\t"+"ENAME\t"+"JOB\t\t"+"SAL");
			System.out.println("============================================");
			
			// Step #5: Print result from ResultSet
			if(rs!=null) {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
				}
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// Step #6: Close the resources
			if(rs!=null) {
				try {
					rs.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}	
	}
}
	
