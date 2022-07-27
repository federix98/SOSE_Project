package it.univaq.disim.sose.ratingupdater.service;
import java.util.List;

import it.univaq.disim.sose.ratingupdater.data.RatingUpdaterDAO;
import it.univaq.disim.sose.ratingupdater.model.GlobalScoreData;
import it.univaq.disim.sose.ratingupdater.model.RatingData;
import it.univaq.disim.sose.ratingupdater.utils.UtilityMethods;

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
	
	@SuppressWarnings("unused")
	private boolean checkExistingUserWithToken() {
		// Implement Async Callback to check 
		return true;
	}

	public boolean addRating(RatingData toAdd) throws Exception {
		UtilityMethods.consoleLog("Adding: " + toAdd.toString());
		
		if (!UtilityMethods.IntegrityCheck(toAdd)) return false;
		return RatingUpdaterDAO.getInstance().getRatingDataDAO().insertRatingData(toAdd);
	}
	
	public boolean updateGlobalScore(RatingData newRatingData) {
		
		GlobalScoreData score = RatingUpdaterDAO.getInstance().getGlobalScoreDAO().readGlobalScore(newRatingData.getFilmId());
		UtilityMethods.consoleLog("score " + score);
		
		if (score == null) {
			// Score does not exists : INSERT
			score = new GlobalScoreData(
					newRatingData.getFilmId(),
					UtilityMethods.calculateSummaryScore(newRatingData),
					1);
			return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().updateGlobalScore(score);
		}
		else {
			// UPDATE
			double newGlobalScore = (score.getGlobalScore() * score.getNumberOfRatings() + UtilityMethods.calculateSummaryScore(newRatingData)) / (score.getNumberOfRatings() + 1);
			
			score.setNumberOfRatings(score.getNumberOfRatings() + 1);
			score.setGlobalScore(newGlobalScore);
			
			return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().updateGlobalScore(score);
		}
		
	}
	
	public RatingData getRatingAverages(String filmId) throws Exception {
		List<RatingData> filmRatings = RatingUpdaterDAO.getInstance().getRatingDataDAO().getAllRatingDataByFilmId(filmId);
		
		RatingData average = new RatingData(filmId, -1, 0, 0, 0, 0, 0);
		average.setFilmDirectionRating(new Double(filmRatings.stream().mapToInt(p -> p.getFilmDirectionRating()).average().orElse(0)).intValue());
		average.setActorsRating(new Double(filmRatings.stream().mapToInt(p -> p.getActorsRating()).average().orElse(0)).intValue());
		average.setGlobalScoreRating(new Double(filmRatings.stream().mapToInt(p -> p.getGlobalScoreRating()).average().orElse(0)).intValue());
		average.setDialoguesRating(new Double(filmRatings.stream().mapToInt(p -> p.getDialoguesRating()).average().orElse(0)).intValue());
		average.setCostumerRating(new Double(filmRatings.stream().mapToInt(p -> p.getCostumerRating()).average().orElse(0)).intValue());
		return average;
		
	}
	
	public List<RatingData> getAllRatings(String filmId) throws Exception {
		return RatingUpdaterDAO.getInstance().getRatingDataDAO().getAllRatingDataByFilmId(filmId);
	}
	
	public GlobalScoreData getGlobalScore(String filmId) throws Exception {
		return RatingUpdaterDAO.getInstance().getGlobalScoreDAO().readGlobalScore(filmId);
	}
}
