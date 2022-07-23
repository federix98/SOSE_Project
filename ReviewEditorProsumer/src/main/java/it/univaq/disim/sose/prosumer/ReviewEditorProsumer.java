package it.univaq.disim.sose.prosumer;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.model.Review;

@WebService
public interface ReviewEditorProsumer {
	

	@WebMethod
	String insertReview(Review review, RatingData ratingData);
	
	//public String 

}
