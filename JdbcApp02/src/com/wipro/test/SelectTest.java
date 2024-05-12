// Display Informations of predefined tables (emp or dept) from Oracle Database using JDBC. 

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
			
			//Step #2: Establish connection between Java Application and Database
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Tiger");
			
			// Step #3: Create Statement object
			if(con!=null) {
				st = con.createStatement();
			}
			
			//System.out.println("EMPNO\t"+"ENAME\t"+"SAL\t"+"DEPTNO\t");   // Predefined Table EMP
			System.out.println("DEPTNO\t\t"+"DNAME\t\t"+"LOC");  //Predefined table DEPT 
			System.out.println("===========================================");
			// Step #4: Send and Execute SQL Query
			if(st!=null) {
				//rs = st.executeQuery("SELECT EMPNO,ENAME,SAL,DEPTNO FROM EMP");
				rs = st.executeQuery("SELECT DEPTNO,DNAME,LOC FROM DEPT");
			}
			
			// Step #5: Process results from ResultSet 
			if(rs!=null) {
				while(rs.next()) {
					//System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getInt(4));
					System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
				}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
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
