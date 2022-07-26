package it.univaq.disim.sose.service.Authentic;

import java.sql.SQLException;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;

import it.univaq.disim.sose.service.DAO.DAOFactory;
import it.univaq.disim.sose.service.DAO.UserDAO;
import it.univaq.disim.sose.utils.Utils;

public class AuthServiceImpl implements AuthService {
	
	{
		UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getUserDAO();
		try {
			userDAO.createTableDB();
			Utils.consoleLog("database created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String login(String username, String password)  {
		UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getUserDAO();
		int userID = userDAO.login(username, password);
		System.out.println("userID: "+userID);
		if(userID == 0) return new JSONObject("The user not exists").toString();
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		boolean res = userDAO.insertToken(userID, generatedString);
		if(res) return generatedString;
		return null;
	}

	@Override
	public String signup(String username, String password) throws SQLException {
		UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getUserDAO();
		
		return String.valueOf(userDAO.signup(username, password));
	}

	@Override
	public String checkUser(int userID, String userToken) throws SQLException {
		UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getUserDAO();

		if( userDAO.checkToken(userID, userToken)) return "User is logged";
		return "User not logged";
	}

	

	
}