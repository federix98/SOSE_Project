package it.univaq.disim.sose.data;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.model.RatingData;

public class RatingDataClient {

	private static final String RatingDataServiceURL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getAllRatings";
	
	public static List<RatingData> getAllRatings(String filmId) {
		WebClient client = WebClient.create(RatingDataServiceURL + "?filmId=" + filmId);
		System.out.println("Calling: " + RatingDataServiceURL + "?filmId=" + filmId);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		
		//xstream.allowTypesByWildcard(new String[]{"com.baeldung.**"});
		
		String content = response.readEntity(String.class);
		System.out.println("Content: " + content);
		
		JSONArray responseArray = new JSONArray(content);
		System.out.print(responseArray.toString(2));
		
		List<RatingData> ratingList = new ArrayList<RatingData>();
		
		for (int i = 0; i < responseArray.length(); i++) {
			JSONObject ratingJSON = responseArray.getJSONObject(i);
			ratingList.add(
					new RatingData(
							ratingJSON.getString("filmId"), 
							ratingJSON.getInt("userId"), 
							ratingJSON.getInt("filmDirectionRating"), 
							ratingJSON.getInt("actorsRating"),
							ratingJSON.getInt("globalScoreRating"),
							ratingJSON.getInt("dialoguesRating"),
							ratingJSON.getInt("costumerRating")
							));
		}
		return ratingList;
		
	}
	
}
