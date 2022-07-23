package it.univaq.disim.sose.filmdetails.data;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.thoughtworks.xstream.XStream;

import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.model.ReviewList;

public class ReviewDataClient {
	
	private static final String ReviewDataServiceURL = "http://localhost:8080/ReviewDataService/rest/Review/getReviewsByFilmID";
	
	public static ReviewList getReviewData(String filmId) {
		
		WebClient client = WebClient.create(ReviewDataServiceURL + "?filmID=" + filmId);
		System.out.println("Calling: " + ReviewDataServiceURL + "?filmID=" + filmId);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		
		//xstream.allowTypesByWildcard(new String[]{"com.baeldung.**"});
		
		String content = response.readEntity(String.class);
		System.out.println("Content: " + content);
		
		JSONArray responseArray = new JSONArray(content);
		System.out.print(responseArray.toString(2));
		
		List<Review> reviewList = new ArrayList<Review>();
		
		for (int i = 0; i < responseArray.length(); i++) {
			JSONObject reviewJSON = responseArray.getJSONObject(i);
			reviewList.add(
					new Review(
							reviewJSON.getInt("filmID"), 
							reviewJSON.getInt("userID"), 
							reviewJSON.getString("title"), 
							reviewJSON.getString("comment")
							));
		}
		
		/**
		 * XML RESPONSE
		 * 
		 * 	XStream xstream = new XStream();
			xstream.allowTypesByWildcard(new String[] { 
			        "it.univaq.disim.sose.**"
			        });
			
			xstream.alias("Reviews", ReviewList.class);
		 */
		
		
		ReviewList responseList = new ReviewList(reviewList);
		
		// System.out.println(responseList.toString());
		return responseList;
		
	}

}
