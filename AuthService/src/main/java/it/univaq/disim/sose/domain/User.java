package it.univaq.disim.sose.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "User")
public class User {


	private int  userID;
	private String username; 
	private String password;
	private String token;


		
	public User( int userID,String username,String password, String token) {
		super();
		
		this.userID = userID;
		this.username = username;	
		this.password = password;
		this.token = token;
	
	}
	
	public User(ResultSet res) throws SQLException {
		this.userID = res.getInt(1);
		this.username = res.getString(2);
		this.password = res.getString(3);
		this.token = res.getString(4);
	
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	

	
}
