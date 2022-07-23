package it.univaq.disim.sose.filmdetails.data;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;

import it.univaq.disim.sose.model.RatingData;

public class RatingDataClient {

	private static final String ReviewDataServiceURL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getRatingAvgs";
	
	public static RatingData getRatingData(String filmId) {
		
		WebClient client = WebClient.create(ReviewDataServiceURL + "?filmId=" + filmId);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		RatingData objToReturn = new RatingData(new JSONObject(response.readEntity(String.class)));
		System.out.println(objToReturn.toString());
		return objToReturn;
		
	}
	
}
