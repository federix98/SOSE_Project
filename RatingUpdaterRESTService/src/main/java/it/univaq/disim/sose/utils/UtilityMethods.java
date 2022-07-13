package it.univaq.disim.sose.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import it.univaq.disim.sose.data.RatingUpdaterDAO;
import it.univaq.disim.sose.model.RatingData;

public class UtilityMethods {
	
	
	public static boolean IntegrityCheck(RatingData ratingDataToAdd) {
	    
	    List<RatingData> existingData = RatingUpdaterDAO.getInstance().getRatingDataDAO().getAllRatingData();
	    
	 // Check if user has already inserted a rating on that film
	    if (existingData != null) {
	    	for (RatingData record : existingData) {
		    	if (ratingDataToAdd.getFilm_id() == record.getFilm_id() && ratingDataToAdd.getUser_id() == record.getUser_id()) return false;
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
		return rates.getFilm_direction_rating() * weights[0] 
				+ rates.getActors_rating() * weights[1]
				+ rates.getGlobal_score_rating() * weights[2]
				+ rates.getDialogues_rating() * weights[3]
				+ rates.getCostumer_rating() * weights[4];
	}
	
}
