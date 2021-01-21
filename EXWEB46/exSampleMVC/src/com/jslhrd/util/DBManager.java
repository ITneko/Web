package com.jslhrd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
	public static Connection getConnection() {

		Connection conn = null;

		String myDriver = "oracle.jdbc.driver.OracleDriver";
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myID = "jslhrd46";
		String myPass = "1234";
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myURL, myID, myPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

		/*
		  Connection myConn = null; try { Context initContext = new InitialContext();
		  Context envContext = (Context) initContext.lookup("java:/comp/env");
		  
		  DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		  
		  myConn = ds.getConnection(); } catch (Exception e) { e.printStackTrace(); }
		  
		  return myConn;
		 */
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}