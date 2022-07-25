package it.univaq.disim.sose.data;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;

import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.utils.Utility;


public class RatingDataClient {

	private static final String ReviewDataServiceURL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/addRatings";
	
	public static String insertRatings(RatingData ratingData) {
		
		WebClient client = WebClient.create(ReviewDataServiceURL 
				+ "?userId=" + ratingData.getUserId()
				+ "&filmId=" + ratingData.getFilmId()
				+ "&filmDirectionRating=" + ratingData.getFilmDirectionRating()
				+ "&actorsRating=" + ratingData.getActorsRating()
				+ "&globalScoreRating=" + ratingData.getGlobalScoreRating()
				+ "&dialoguesRating=" + ratingData.getDialoguesRating()
				+ "&costumesRating=" + ratingData.getCostumerRating());
				
				
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		//RatingData objToReturn = new RatingData(new JSONObject(response.readEntity(String.class)));
		//Utility.consoleLog(objToReturn.toString());
		return "";//objToReturn;
		
	}
	
}
