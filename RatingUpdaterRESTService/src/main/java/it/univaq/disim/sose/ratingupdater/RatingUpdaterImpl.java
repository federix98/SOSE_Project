package it.univaq.disim.sose.ratingupdater;

import java.io.IOException;
import java.net.URISyntaxException;

import it.univaq.disim.sose.data.RatingDataDAO_RDF;
import it.univaq.disim.sose.data.RatingDataDAO_SQLLite;
import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.service.RatingUpdaterService;
import it.univaq.disim.sose.utils.UtilityMethods;

public class RatingUpdaterImpl implements RatingUpdater {
	
	@Override
	public String add_ratings(int user_id, int film_id, int film_direction_rating, int actors_rating, int global_score_rating, int dialogues_rating, int costumes_rating) {
		// TODO Auto-generated method stub
		
		RatingData objToAdd = new RatingData(film_id, user_id, film_direction_rating, actors_rating, global_score_rating, dialogues_rating, costumes_rating);
		
		try {
			boolean done = RatingUpdaterService.getInstance().addRating(objToAdd);
			
			if (done) {
				RatingUpdaterService.getInstance().updateGlobalScore(objToAdd);
				return UtilityMethods.buildXMLResponse("Rating inserted successfully", true);
			}
			return UtilityMethods.buildXMLResponse("User has already inserted the book", false);
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return UtilityMethods.buildXMLResponse("Exception durint inserting the book", false);
		}
		
		
	}

}
