package it.univaq.disim.sose.ratingupdater;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.ratingupdater.model.RatingData;
import it.univaq.disim.sose.ratingupdater.model.RatingOperationResponse;
import it.univaq.disim.sose.ratingupdater.service.RatingUpdaterService;

public class RatingUpdaterImpl implements RatingUpdater {
	
	@Override
	public String addRatings(int userId, String filmId, int filmDirectionRating, int actorsRating, int globalScoreRating, int dialoguesRating, int costumesRating) {
		// TODO Auto-generated method stub
		
		RatingData objToAdd = new RatingData(filmId, userId, filmDirectionRating, actorsRating, globalScoreRating, dialoguesRating, costumesRating);
		
		try {
			boolean done = RatingUpdaterService.getInstance().addRating(objToAdd);
			
			if (done) {
				RatingUpdaterService.getInstance().updateGlobalScore(objToAdd);
				return new RatingOperationResponse("Rating inserted and global score updated", true).getJSONResponse();
			}
			return new RatingOperationResponse("User has already inserted the ratings for the film", false).getJSONResponse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new RatingOperationResponse("Exception during add ratings", false).getJSONResponse();
		}
		
		
	}

	@Override
	public String getRatingAvgs(String filmId) {
		// TODO Auto-generated method stub
		
		try {
			return new JSONObject(RatingUpdaterService.getInstance().getRatingAverages(filmId)).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JSONObject(new RatingOperationResponse("Exeption retrieving averages", false)).toString();
		}
	}

	@Override
	public String getAllRatings(String filmId) {
		try {
			return new JSONArray(RatingUpdaterService.getInstance().getAllRatings(filmId)).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JSONObject(new RatingOperationResponse("Exeption retrieving all ratings", false)).toString();
		}
	}

}
