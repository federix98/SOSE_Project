package it.univaq.disim.sose.service.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.univaq.disim.sose.utils.Utils;


public class SQLiteUserDAOImpl implements UserDAO{

	private Connection conn = null;
	private PreparedStatement prep = null;
	private ResultSet res = null;
	
	private final String CREATE_DATABASE_TABLE = "CREATE TABLE IF NOT EXISTS user (user_id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT, password TEXT, token TEXT);";
	private final String LOGIN = "SELECT user_id FROM user WHERE username = ? AND password = ?";
	private final String SIGNUP = "INSERT INTO user(username, password) VALUES (?, ?)";
	private final String INSERT_TOKEN = "UPDATE user SET token = ? where user_id = ?";
	private final String CHECK_TOKEN = "SELECT token FROM user WHERE user_id = ? AND token = ? ";
	
	
	@Override
	public void createTableDB()  {
		try {
		conn = SQLiteDAOFactory.createConnection();
		
        Statement statement = conn.createStatement();
        statement.executeUpdate(CREATE_DATABASE_TABLE);
        Utils.consoleLog("database create");
        

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	}



	@Override
	public int signup(String username, String password) throws SQLException {
		try {
			conn = SQLiteDAOFactory.createConnection();
			//Utils.consoleLog(review.toString());
			prep = conn.prepareStatement(SIGNUP);
			prep.setString(1, username);
			prep.setString(2, password);
			prep.executeUpdate();
			try (ResultSet generatedKeys = prep.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	return generatedKeys.getInt(1);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			
		}
		catch(SQLException e ) {
			e.printStackTrace();
			return 0;

		}
		finally {
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	}



	@Override
	public int login(String username, String password) {

		try {
			conn = SQLiteDAOFactory.createConnection();
			prep = (PreparedStatement) conn.prepareStatement(LOGIN);
			prep.setString(1, username);
			prep.setString(2, password);
			res = prep.executeQuery();
			
			
			if(res.next()) {
				return res.getInt(1);
			}
			return 0;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		finally {
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);

		}
	}



	@Override
	public boolean checkToken(int userID, String token) {
		try {
			conn = SQLiteDAOFactory.createConnection();
			prep = (PreparedStatement) conn.prepareStatement(CHECK_TOKEN);
			prep.setInt(1, userID);
			prep.setString(2, token);
			res = prep.executeQuery();
			
			if(res.next()) {
				
				return true;
			}
			return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);

		}
	}



	@Override
	public boolean insertToken(int userID, String token) {
		try {
			conn = SQLiteDAOFactory.createConnection();
			prep = conn.prepareStatement(INSERT_TOKEN);
			prep.setString(1, token);
			prep.setInt(2, userID);
			prep.executeUpdate();
			return true;
		}
		catch(SQLException e ) {
			e.printStackTrace();
			return false;

		}
		finally {
			SQLiteDAOFactory.closeDbConnection(res, prep, conn);
		}
	}

	



}
