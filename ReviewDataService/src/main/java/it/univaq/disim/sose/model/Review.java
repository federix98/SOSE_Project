package it.univaq.disim.sose.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Review {
	
	
	private String  filmID;
	private int userID; 
	private String title;
	private String comment;

		
	public Review(String filmID, int userID,String title, String comment) {
		super();
		this.filmID = filmID;
		this.userID = userID;
		this.title = title;	
		this.comment = comment;
	}
	
	public Review(ResultSet resultSet) throws SQLException {
		this.filmID = resultSet.getString(1);
		this.userID = resultSet.getInt(2);
		this.title = resultSet.getString(3);
		this.comment = resultSet.getString(4);
	}

	public String getFilmID() {
		return filmID;
	}

	public void setFilmID(String filmID) {
		this.filmID = filmID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Review [filmID=" + filmID + ", userID=" + userID + ", title=" + title + ", comment=" + comment + "]";
	}

	
	
}
