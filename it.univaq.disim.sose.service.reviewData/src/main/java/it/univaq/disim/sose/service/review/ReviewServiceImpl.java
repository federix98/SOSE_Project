package it.univaq.disim.sose.service.review;

import java.sql.SQLException;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.model.ReviewList;
import it.univaq.disim.sose.service.DAO.DAOFactory;
import it.univaq.disim.sose.service.DAO.ReviewDAO;
import it.univaq.disim.sose.utils.Utils;

public class ReviewServiceImpl implements ReviewService{
	
	{
		ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
		try {
			reviewDAO.createTableDB();
			System.out.println("database created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	@Override
	public String getReviewsByUserID(int userID) throws SQLException {
		ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
		List<Review> reviewList = reviewDAO.getReviewsByUserID(userID);
		XStream xstream = new XStream();
	    xstream.alias("Reviews", List.class);
	    System.out.println(xstream.toXML(reviewList));
		return Utils.buildXMLResponse(xstream.toXML(reviewList));
	}

	@Override
	public String getReviewsByFilmID(int filmID) throws SQLException {
		ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
		List<Review> reviewList = reviewDAO.getReviewsByFilmID(filmID);
		
		ReviewList reList = new ReviewList(reviewList);
		XStream xstream = new XStream();
	    xstream.alias("Reviews", ReviewList.class);
	    System.out.println(xstream.toXML(reList));
	    
	    System.out.println(reviewList.size());
	   
		return Utils.buildXMLResponse(xstream.toXML(reList));
	}

	@Override
	public String getReviewByFilmIDUserID(int filmID, int userID) throws SQLException {
		ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
		Review rev = reviewDAO.getReviewByFilmIDByUserID(filmID, userID);
		XStream xstream = new XStream();
	    xstream.alias("Review", Review.class);
	    System.out.println(xstream.toXML(rev));
		return Utils.buildXMLResponse(xstream.toXML(rev));
	}

	@Override
	public String insertReview(int filmID, String title, String text, int userID) {
		System.out.print("filmID: "+ filmID+ " title: "+ title+ " text: "+ text+ " userID: "+ userID);
		boolean response = false;
		try {
			 ReviewDAO reviewDAO = DAOFactory.getDAOFactory(DAOFactory.SQLITE).getReviewDAO();
			 response = reviewDAO.inserReview(new Review(filmID,userID, title, text));
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		

		}
		if(response) return Utils.buildXMLResponse("<response> inserted </response>");
		return Utils.buildXMLResponse("<response> not inserted, there is already another one </response>");
		
	}


}
