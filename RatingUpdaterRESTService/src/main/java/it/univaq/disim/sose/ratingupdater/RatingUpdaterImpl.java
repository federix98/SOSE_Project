package it.univaq.disim.sose.ratingupdater;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONObject;

import it.univaq.disim.sose.ratingupdater.model.RatingData;
import it.univaq.disim.sose.ratingupdater.service.RatingUpdaterService;
import it.univaq.disim.sose.ratingupdater.utils.UtilityMethods;

public class RatingUpdaterImpl implements RatingUpdater {
	
	@Override
	public String addRatings(int userId, String filmId, int filmDirectionRating, int actorsRating, int globalScoreRating, int dialoguesRating, int costumesRating) {
		// TODO Auto-generated method stub
		
		RatingData objToAdd = new RatingData(filmId, userId, filmDirectionRating, actorsRating, globalScoreRating, dialoguesRating, costumesRating);
		
		try {
			boolean done = RatingUpdaterService.getInstance().addRating(objToAdd);
			
			if (done) {
				RatingUpdaterService.getInstance().updateGlobalScore(objToAdd);
				return UtilityMethods.buildXMLResponse("Rating inserted successfully", true);
			}
			return UtilityMethods.buildXMLResponse("User has already inserted the ratings for the film", false);
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return UtilityMethods.buildXMLResponse("Exception during add ratings", false);
		}
		
		
	}

	@Override
	public String getRatingAvgs(String filmId) {
		// TODO Auto-generated method stub
		
		return new JSONObject(RatingUpdaterService.getInstance().getRatingAverages(filmId)).toString();
	}

}
