package it.univaq.disim.sose.data;


import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;

import it.univaq.disim.sose.callbacks.Callback;
import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.utils.Utility;


public class ClientAsync {

	private static final String RatingDataServiceAsyncURL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/addRatingsAsync";
	
	private static final String ReviewDataServiceAsyncURL = "http://localhost:8080/ReviewDataService/rest/Review/insertReviewAsync";
	
	public static String insertRatings(RatingData ratingData, Review review) throws Exception {
		
		Client client = ClientBuilder.newClient();
		
		Callback handlerRating = new Callback();
		Callback handlerReview = new Callback();
		
		URL RatingAsyncURL = new URL(RatingDataServiceAsyncURL 
				+ "?userId=" + ratingData.getUserId()
				+ "&filmId=" + ratingData.getFilmId()
				+ "&filmDirectionRating=" + ratingData.getFilmDirectionRating()
				+ "&actorsRating=" + ratingData.getActorsRating()
				+ "&globalScoreRating=" + ratingData.getGlobalScoreRating()
				+ "&dialoguesRating=" + ratingData.getDialoguesRating()
				+ "&costumesRating=" + ratingData.getCostumerRating());
		
		URL ReviewAsyncURL = new URL(ReviewDataServiceAsyncURL 
				+ "?filmID=" + review.getFilmID() 
				+ "&title=" + URLEncoder.encode(review.getTitle())
				+ "&text=" + URLEncoder.encode(review.getComment()) 
				+ "&userID="+review.getUserID());
		
		Utility.consoleLog("Calling " + RatingAsyncURL + " " + ReviewAsyncURL);
		
		
		Utility.consoleLog("Invoking async addRatings method from RatingUpdaterService");
		Future<Response> futureResponseRating = client.target(RatingAsyncURL.toString()).request().async().get(handlerRating);
			
		Utility.consoleLog("Invoking async addReview method from RatingUpdaterService");
		Future<Response> futureResponseReview = client.target(ReviewAsyncURL.toString()).request().async().get(handlerReview);
		
				
		while (!futureResponseRating.isDone() || !futureResponseReview.isDone()) {
			// Doing something
			Thread.sleep(1000);
			Utility.consoleLog("Waiting for async completion [futureResponseRating " + futureResponseRating.isDone() + ", futureResponseReview " + futureResponseReview.isDone() + "]");
		}
		
		Response reviewResponse = futureResponseReview.get();
		Response ratingResponse = futureResponseRating.get();
		
		Utility.consoleLog("Review Response Async: " + reviewResponse.readEntity(String.class));
		Utility.consoleLog("Rating Response Async: " + ratingResponse.readEntity(String.class));
		
		if (reviewResponse.readEntity(String.class).contains("not")) {
			return "ERROR";
		}
		
		if (!(new JSONObject(ratingResponse.readEntity(String.class)).getBoolean("Outcome"))) {
			return "ERROR";
		}
		
		
		Utility.consoleLog("Received response from service - Inserted");
		
		
		return "Review and Rating async inserted successfully";//objToReturn;
		
	}
	
}
