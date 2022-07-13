package it.univaq.disim.sose.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.sose.data.RatingUpdaterDAO;
import it.univaq.disim.sose.model.GlobalScoreData;
import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.utils.UtilityMethods;

public class RatingUpdaterService {
	
	private static RatingUpdaterService instance;
	
	private RatingUpdaterService() {
		
	}
	
	public static synchronized RatingUpdaterService getInstance() {
		if (instance == null) {
			instance = new RatingUpdaterService();
		}
		return instance;
	}
	
	private boolean checkExistingUserWithToken() {
		// Implement Async Callback to check 
		return true;
	}

	public boolean addRating(RatingData toAdd) throws IOException, URISyntaxException {
		System.out.println("Updating with the following parameters for user " + toAdd.getUser_id() + " and film " + toAdd.getFilm_id()
		+ ": [film direction: " + toAdd.getFilm_direction_rating() 
		+ ", actors: " + toAdd.getActors_rating() 
		+ ", global_score: " + toAdd.getActors_rating() 
		+ ", dialogues: " + toAdd.getActors_rating() 
		+ ", costumes: " + toAdd.getActors_rating() 
		+ "]");
		
		if (!UtilityMethods.IntegrityCheck(toAdd)) return false;
		RatingUpdaterDAO.getInstance().getRatingDataDAO().insertRatingData(toAdd);
		
		return true;
	}
	
	public boolean updateGlobalScore(RatingData newRatingData) {
		
		GlobalScoreData score = RatingUpdaterDAO.getInstance().getGlobalScoreDAO().readGlobalScore(newRatingData.getFilm_id());
		System.out.println("score " + score);
		
		if (score == null) {
			// Score does not exists : INSERT
			score = new GlobalScoreData(
					newRatingData.getFilm_id(),
					UtilityMethods.calculateSummaryScore(newRatingData),
					1);
			return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().updateGlobalScore(score);
		}
		else {
			// UPDATE
			double newGlobalScore = (score.getGlobal_score() * score.getNumber_of_ratings() + UtilityMethods.calculateSummaryScore(newRatingData)) / (score.getNumber_of_ratings() + 1);
			
			score.setNumber_of_ratings(score.getNumber_of_ratings() + 1);
			score.setGlobal_score(newGlobalScore);
			
			return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().updateGlobalScore(score);
		}
		
	}
	
}
