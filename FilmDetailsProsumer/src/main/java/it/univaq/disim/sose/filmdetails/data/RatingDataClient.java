package it.univaq.disim.sose.filmdetails.data;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.model.AggregatedRatingData;
import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.model.ReviewList;
import it.univaq.disim.sose.service.FilmDetailsAggregator;
import it.univaq.disim.sose.service.FilmDetailsAggregatorImplService;

public class RatingDataClient {

	// private static final String ReviewDataServiceURL = "http://localhost:8080/ratingUpdaterService/rest/ratingupdaterservice/getRatingAvgs";
	
	public static AggregatedRatingData getRatingData(String filmId) {
		
		FilmDetailsAggregatorImplService service = new FilmDetailsAggregatorImplService();
		FilmDetailsAggregator port = service.getFilmDetailsAggregatorImplPort();
		
		it.univaq.disim.sose.service.AggregatedRatingData ratingAvg = port.aggregateRatings(filmId);
		
		AggregatedRatingData objToReturn = new AggregatedRatingData();
		objToReturn.setFilmId(ratingAvg.getFilmId());
		objToReturn.setUserId(ratingAvg.getUserId());
		objToReturn.setActorsRating(ratingAvg.getActorsRating());
		objToReturn.setCostumerRating(ratingAvg.getCostumerRating());
		objToReturn.setFilmDirectionRating(ratingAvg.getFilmDirectionRating());
		objToReturn.setGlobalScoreRating(ratingAvg.getGlobalScoreRating());
		objToReturn.setDialoguesRating(ratingAvg.getDialoguesRating());
		objToReturn.setGlobalScore(ratingAvg.getGlobalScore());
		objToReturn.setNumberOfRatings(ratingAvg.getNumberOfRatings());
		
		return objToReturn;
		
	}
	
}
