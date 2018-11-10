package com.DugmaHadash.com.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.el.stream.StreamELResolverImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MySqlHandler {
	private static Connection conn;
	public static String db_address = "localhost";
	public static String db_name = "makolet";
	public static String db_user = "root";
	public static String db_pass = "1234";
//	
//	
//	 public static void connect2 {

	// getConnection("127.0.0.1/", "root", "");
	// creatDB("coffee");
	// createTable("coffetype");
	// insertToCoffeTable("1237", "SELECT * FROM coffetype");
	// for (int i = 0; i < 1000; i++) {
	// insertToCoffeTable("123487"+i, "caffe"+i+100);
	// }
	// inserttocoffeTransiction();
	// ResultSet rs = runCoffeSelect();
	// while(rs.next()){
	// System.out.printf("id %8s type %10s\n",rs.getString(1), rs.getString(2));
	// }
	// tableMeta();
	// closeConnetion();

	// }
	
	public static void sqlAction(String sqlstat) {
	
		Statement statement;
		try {
			statement = conn.createStatement();
			System.out.println(sqlstat);
			statement.executeUpdate(sqlstat);
//			statement.
			System.out.println("2");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void setDb(String DbName) {
		String sql = "USE `" + DbName + "`;";
		Statement statement;
		try {
			statement = conn.createStatement();
			
			statement.executeUpdate(sql);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void tableMeta() {
		try {
			ResultSet resultSet = runCoffeSelect();
			ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
			System.out.println(rsmd.getColumnCount());
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String name = rsmd.getColumnName(i);
				int type = rsmd.getColumnType(i);
				System.out.printf("col name %s col type %d\n", name, type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createTable(String tbl_name , String sqlStat) {
		String sql = "CREATE TABLE " + tbl_name + "(" + sqlStat+ ")";
//				+ " ( `usermame` VARCHAR(10), `type` VARCHAR(30) NULL,  PRIMARY KEY (`usermame`),  UNIQUE INDEX `usermame_UNIQUE` (`usermame` ASC));";
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void insertToCoffeTable(String id, String type) {
		try {
			String sql = "INSERT INTO coffetype VALUES (?, ?);";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, type);
			// Statement st = conn.createStatement();
			// st.execute(sql);
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void creatDB(String db_name) {
		String sql = "CREATE DATABASE " + db_name;
		Statement statement = null;

		try {
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			System.out.println("created  " + db_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	 

	public static void getConnection(String db_address, String db_name, String db_pass) {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://" + db_address
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					db_name, db_pass);
			// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
			//conn.setAutoCommit(false);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeConnetion() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void inserttocoffeTransiction() {
		for (int i = 0; i < 500; i++) {
			insertToCoffeTable("13" + i, "white " + i * 100);
		}
		insertToCoffeTable("12" + 0, "black " + 0 * 100);
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static ResultSet runCoffeSelect() {
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM coffetype");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return resultSet;

	}

}// end class
