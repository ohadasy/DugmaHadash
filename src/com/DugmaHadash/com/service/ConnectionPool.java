package com.DugmaHadash.com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ConnectionPool {

	private static final int NUM_OF_CONNECTIONS = 3;

	private Set<Connection> pool = new HashSet<>();
	private List<Connection> availableConnections = new LinkedList<>();

	private static ConnectionPool instance = new ConnectionPool();

	private ConnectionPool() {
		for (int i = 0; i < NUM_OF_CONNECTIONS; i++) {
			Connection connection = createConnection("127.0.0.1/", "root", "");
			pool.add(connection);
			availableConnections.add(connection);
		}
	}

	private Connection createConnection(String db_address, String db_name, String db_pass) {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://" + db_address
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					db_name, db_pass);
			setDb(connection, "couponproj1");
			return connection;
			// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
			// conn.setAutoCommit(false);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			throw new CouponException("could don't my sql driver", e1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CouponException("could don't create connection", e);
		}

	}

	public static void setDb(Connection conn, String DbName) {
		String sql = "USE `" + DbName + "`;";
		Statement statement;
		try {
			statement = conn.createStatement();

			statement.executeUpdate(sql);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static ConnectionPool getInstance() {
		return instance;
	}

	public Connection getConnection() {
		Connection connection = availableConnections.get(0);
		availableConnections.remove(0);
		return connection;

	}

	public void returnconnection(Connection connection) {
		availableConnections.add(connection);
	}

	public void closeAllConnections() {

	}

}
