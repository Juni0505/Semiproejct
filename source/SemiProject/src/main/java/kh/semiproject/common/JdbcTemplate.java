package kh.semiproject.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcTemplate { 
	private static Connection conn = null;
	
	// Singleton패턴 Connection 객체가 많이 생성됨을 방지
	public static Connection getConnection() {
		Properties prpt = new Properties();
		String currentPath = JdbcTemplate.class.getResource("./").getPath();
		Connection conn = null;
		
		try {
			prpt.load(new BufferedReader(new FileReader(currentPath+"drvier.properties")));
			String driver = prpt.getProperty("driver");
			String url = prpt.getProperty("url");
			String user = prpt.getProperty("user");
			String pwd = prpt.getProperty("pwd");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			if(conn != null)
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null)
				stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void setAutoCommint(Connection conn, boolean auto) {
		try {
			conn.setAutoCommit(auto);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
