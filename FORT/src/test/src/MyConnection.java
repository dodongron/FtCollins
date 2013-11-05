/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author i1
 */
public class MyConnection {

	private MyConnection() {
		// config_pool_connection();
	}

	private static Connection conn;

	public static Connection connect() {
		try {
			// init();
//			String host = System.getProperty("pool_host", "198.58.84.196");
//			String user = System.getProperty("pool_user", "jronny_arcsys");
//			String password = System.getProperty("pool_password", "P@s5w0rd");
//			String dbName = System.getProperty("dbName", "jronny_arcsys");
//			
			String host = System.getProperty("pool_host", "localhost:3306");
			String user = System.getProperty("pool_user", "root");
			String password = System.getProperty("pool_password", "password");
			String dbName = System.getProperty("dbName", "db_arcsys");

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + host + "/"+dbName;
//			String url = "jdbc:mysql://localhost/db_arcsys";
			try {
				conn = DriverManager.getConnection(url, user, password);
				// DriverManager.getConnection("proxool.pool_connection");
			} catch (SQLException ex) {
				Logger.getLogger(MyConnection.class.getName()).log(
						Level.SEVERE, null, ex);
			}

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return conn;
	}
	public static void close() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		connect();
	}
}
