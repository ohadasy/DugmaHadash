package com.DugmaHadash.com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ConnectionPool {
	
	private static final int NUM_OF_CONNECTIONS = 3;

	private Set<Connection> pool = new HashSet<>();
	
	private static ConnectionPool instance = new ConnectionPool();
	
	private ConnectionPool() {
		for (int i = 0; i < NUM_OF_CONNECTIONS; i++) {
			
			Connection connection = createConnection("127.0.0.1/", "root", "");
			pool.add(connection);
		}
	}
	
	private Connection createConnection(String db_address, String db_name, String db_pass) {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection("jdbc:mysql://" + db_address
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					db_name, db_pass);
			// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
			//conn.setAutoCommit(false);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
			throw new CouponException("could don't my sql driver", e1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CouponException("could don't create connection", e);
		}
	}
	public static ConnectionPool getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		return null;
	}

	public void returnconnection(Connection connection) {

	}

	public void closeAllConnections() {

	}

}
