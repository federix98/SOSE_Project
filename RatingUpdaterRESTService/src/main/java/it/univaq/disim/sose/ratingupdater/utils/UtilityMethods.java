package it.univaq.disim.sose.ratingupdater.utils;

import java.util.List;

import it.univaq.disim.sose.ratingupdater.data.RatingUpdaterDAO;
import it.univaq.disim.sose.ratingupdater.model.RatingData;

public class UtilityMethods {
	
	
	public static boolean IntegrityCheck(RatingData ratingDataToAdd) {
	    
	    List<RatingData> existingData = RatingUpdaterDAO.getInstance().getRatingDataDAO().getAllRatingData();
	    
	 // Check if user has already inserted a rating on that film
	    if (existingData != null) {
	    	for (RatingData record : existingData) {
		    	if (ratingDataToAdd.getFilmId() == record.getFilmId() && ratingDataToAdd.getUserId() == record.getUserId()) return false;
		    }
	    }
	    
		return true;
	}
	
	public static String buildXMLResponse(String content, boolean inserted) {
		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		response += "<response><message>" + content + "</message><inserted>" + inserted + "</inserted></response>";
		return response;
	}
	
	public static double calculateSummaryScore(RatingData rates) {
		double[] weights = { 0.2, 0.2, 0.3, 0.2, 0.1 };
		return rates.getFilmDirectionRating() * weights[0] 
				+ rates.getActorsRating() * weights[1]
				+ rates.getGlobalScoreRating() * weights[2]
				+ rates.getDialoguesRating() * weights[3]
				+ rates.getCostumerRating() * weights[4];
	}
	
}
