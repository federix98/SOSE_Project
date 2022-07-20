package it.univaq.disim.sose.service.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDAOFactory extends DAOFactory {
	
	public static final String DRIVER = "org.sqlite.JDBC";
	//public static final String DATABASE = "jdbc:sqlite:/Users/alessandrodimatteo/Desktop/sqlite/review.db";
	public static final String DATABASE = "jdbc:sqlite:/Users/federico/Desktop/sqlite/review.db";

	
	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DATABASE);;
			//System.out.println("Connected to database");
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeDbConnection(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs !=null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn!= null) {
				conn.close();
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void DBCreation() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DATABASE);;
			System.out.println("Connected to database ");
			Statement statement = conn.createStatement();
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS review (review_id INTEGER PRIMARY KEY AUTOINCREMENT,film_id INTEGER, title TEXT, comment TEXT, user_id INTEGER");
			System.out.println("Database created ");
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
  

	}

	@Override 
	public ReviewDAO getReviewDAO() {
		return new SQLiteReviewDAOImpl();
	}
}
