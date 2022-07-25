package it.univaq.disim.sose.data;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;

import it.univaq.disim.sose.model.Review;

public class ReviewDataClient {
	
	private static final String ReviewDataServiceURL = "http://localhost:8080/ReviewDataService/rest/Review/insertReview";
	
	public static String insertReviewData(Review review) {
		// 	String insertReview(@QueryParam("filmID")String filmID, @QueryParam("title") String title, @QueryParam("text") String text, @QueryParam("userID") int userID) throws SQLException;

		WebClient client = WebClient.create(ReviewDataServiceURL + "?filmID=" + review.getFilmID()+"&title=" + review.getFilmID()+"&comment=" + review.getFilmID()+ "&userID="+review.getUserID());
		System.out.println(ReviewDataServiceURL + "?filmID=" + review.getFilmID()+"&title=" + review.getFilmID()+"&comment=" + review.getFilmID()+ "&userID="+review.getUserID());
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		System.out.println("Content: " + response.readEntity(String.class));
		JSONObject jsonObject = new JSONObject(response.readEntity(String.class));
		return jsonObject.get("Response").toString();
		

	}

}