package it.univaq.disim.sose.filmdetails.data;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.thoughtworks.xstream.XStream;

import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.model.ReviewList;

public class ReviewDataClient {
	
	private static final String ReviewDataServiceURL = "http://localhost:8080/ReviewDataService/rest/Review/getReviewsByFilmID";
	
	public static ReviewList getReviewData(String filmId) {
		
		WebClient client = WebClient.create(ReviewDataServiceURL + "?filmID=" + filmId);
		System.out.println("Calling: " + ReviewDataServiceURL + "?filmID=" + filmId);
		Response response = client.accept(MediaType.APPLICATION_XML).get();
		
		
		//xstream.allowTypesByWildcard(new String[]{"com.baeldung.**"});
		
		System.out.println("Content: " + response.readEntity(String.class));
		
		
		XStream xstream = new XStream();
		xstream.allowTypesByWildcard(new String[] { 
		        "it.univaq.disim.sose.**"
		        });
		
		xstream.alias("Reviews", ReviewList.class);
		
		ReviewList responseList = (ReviewList) (xstream.fromXML(response.readEntity(String.class)));
		
		// System.out.println(responseList.toString());
		return responseList;
		
	}

}
