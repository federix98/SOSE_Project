package it.univaq.disim.sose.prosumer;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import it.univaq.disim.sose.data.AuthDataClient;
import it.univaq.disim.sose.data.RatingDataClient;
import it.univaq.disim.sose.data.ClientAsync;
import it.univaq.disim.sose.data.ReviewDataClient;
import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.utils.Utility;


public class ReviewEditorProsumerImpl implements ReviewEditorProsumer {

	@Resource
	private WebServiceContext context;
	
	@Override
	public String insertReview(Review review, RatingData ratingData) {
		
	    HttpServletRequest req = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
	    String authToken = req.getHeader("userToken");
	    if(!authToken.isEmpty())  Utility.consoleLog(authToken);
	    else return "You cannot insert reviews if not logged";
	    
	    
	    //if(!AuthDataClient.checkToken(authToken).equals("Logged")) return "you have to sign-in";
	    
	  
	    // if(!ReviewDataClient.insertReviewData(review).equals("inserted")) return "you cannot add more than one review for film";
	    
	    
	    //if(!RatingDataClient.insertRatings(ratingData).equals("Rating inserted successfully")) return "you cannot add more than one rating for film";
	    
	    try {
	    	if(!ClientAsync.insertRatings(ratingData, review).equals("Review and Rating async inserted successfully")) return "you cannot add more than one review and ratings for film";
	    	return "Review inserted";
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    	return "Review not inserted";
	    }
	    
	    
	    
	    
		
	}



}
