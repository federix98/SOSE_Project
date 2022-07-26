package it.univaq.disim.sose.service;

import java.util.List;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;

import org.apache.cxf.jaxws.ServerAsyncResponse;

import it.univaq.disim.sose.data.RatingDataClient;
import it.univaq.disim.sose.model.AggregatedDataResponse;
import it.univaq.disim.sose.model.AggregatedRatingData;
import it.univaq.disim.sose.model.GlobalScoreData;
import it.univaq.disim.sose.model.RatingData;
import it.univaq.disim.sose.utils.Utility;

public class FilmDetailsAggregatorImpl implements FilmDetailsAggregator {

	@Override
	public AggregatedRatingData aggregateRatings(String filmId) {
		// TODO Auto-generated method stub
		
		List<RatingData> ratings = RatingDataClient.getAllRatings(filmId);
		
		GlobalScoreData movieScore = RatingDataClient.getGlobalScore(filmId);
		
		AggregatedRatingData average = new AggregatedRatingData(filmId, -1, 0, 0, 0, 0, 0, 0, 0);
		average.setFilmDirectionRating(new Double(ratings.stream().mapToInt(p -> p.getFilmDirectionRating()).average().orElse(0)).intValue());
		average.setActorsRating(new Double(ratings.stream().mapToInt(p -> p.getActorsRating()).average().orElse(0)).intValue());
		average.setGlobalScoreRating(new Double(ratings.stream().mapToInt(p -> p.getGlobalScoreRating()).average().orElse(0)).intValue());
		average.setDialoguesRating(new Double(ratings.stream().mapToInt(p -> p.getDialoguesRating()).average().orElse(0)).intValue());
		average.setCostumerRating(new Double(ratings.stream().mapToInt(p -> p.getCostumerRating()).average().orElse(0)).intValue());
		average.setGlobalScore(movieScore.getGlobalScore());
		average.setNumberOfRatings(movieScore.getNumberOfRatings());
		return average;
	}

	@Override
	public Future<?> aggregateRatingsAsync(String filmId, AsyncHandler<AggregatedDataResponse> asyncHandler) {
		// TODO Auto-generated method stub
		
		Utility.consoleLog("executing aggregateRatingsAsync");
		
		final ServerAsyncResponse<AggregatedDataResponse> asyncResponse = new ServerAsyncResponse<AggregatedDataResponse>();
		
		new Thread() {
			public void run() {
				
				
				
				List<RatingData> ratings = RatingDataClient.getAllRatings(filmId);
				
				GlobalScoreData movieScore = RatingDataClient.getGlobalScore(filmId);
				
				AggregatedRatingData average = new AggregatedRatingData(filmId, -1, 0, 0, 0, 0, 0, 0, 0);
				average.setFilmDirectionRating(new Double(ratings.stream().mapToInt(p -> p.getFilmDirectionRating()).average().orElse(0)).intValue());
				average.setActorsRating(new Double(ratings.stream().mapToInt(p -> p.getActorsRating()).average().orElse(0)).intValue());
				average.setGlobalScoreRating(new Double(ratings.stream().mapToInt(p -> p.getGlobalScoreRating()).average().orElse(0)).intValue());
				average.setDialoguesRating(new Double(ratings.stream().mapToInt(p -> p.getDialoguesRating()).average().orElse(0)).intValue());
				average.setCostumerRating(new Double(ratings.stream().mapToInt(p -> p.getCostumerRating()).average().orElse(0)).intValue());
				average.setGlobalScore(movieScore.getGlobalScore());
				average.setNumberOfRatings(movieScore.getNumberOfRatings());
				
				AggregatedDataResponse response = new AggregatedDataResponse();
				
				response.setAggregatedRatingData(average);
				
				asyncResponse.set(response);
				Utility.consoleLog("responding with " + average.toString());
				
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();
		
		return asyncResponse;
	}

}
