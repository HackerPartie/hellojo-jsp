package cc.libera.hellojo.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
	private static Connection con = null;
	private static Properties props = new Properties();

	/**
	 * opens a connection to the database, using property file
	 * @return a connection object
	 */
	public static Connection openConnection() {

		try {
			// load a properties file from class path
			props.load(Question.class.getClassLoader().getResourceAsStream(
					"database.properties"));

		} catch (IOException e) {
			Logger lgr = Logger.getLogger(Question.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		}

		String url = props.getProperty("jdbc.url");
		String user = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			Logger lgr = Logger.getLogger(DB.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
			return con;
		}
	}
	
	/**
	 * releases all openstuff related to the database connection
	 * @param rs
	 * @param pst
	 * @param con
	 */
	public static void closeConnection(ResultSet rs, PreparedStatement pst, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(DB.class.getName());
			lgr.log(Level.WARNING, e.getMessage(), e);
		}
	}
}