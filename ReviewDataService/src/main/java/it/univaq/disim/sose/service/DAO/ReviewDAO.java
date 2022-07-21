package it.univaq.disim.sose.service.DAO;

import java.sql.SQLException;
import java.util.List;


import it.univaq.disim.sose.model.Review;

public interface ReviewDAO {
	
	public List<Review> getReviewsByFilmID(String filmID) throws SQLException;
	
	public List<Review> getReviewsByUserID(int userID) throws SQLException;
	
	public Review getReviewByFilmIDByUserID(String filmID, int userID) throws SQLException;
	
	public boolean inserReview(Review review) throws SQLException;

	public void createTableDB() throws SQLException;
	
	
	

}
