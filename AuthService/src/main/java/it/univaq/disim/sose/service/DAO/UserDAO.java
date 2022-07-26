package it.univaq.disim.sose.service.DAO;

import java.sql.SQLException;


public interface UserDAO {
	
	public void createTableDB() throws SQLException;
	
	public int signup(String username, String password) throws SQLException;
	
	public int login(String username, String password); 

	public boolean checkToken(int userID, String token);
	
	public boolean insertToken(int userID, String token);
	

	
	
}
