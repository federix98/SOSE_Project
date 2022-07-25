package it.univaq.disim.sose.service;

import java.util.List;

import it.univaq.disim.sose.data.RatingDataClient;
import it.univaq.disim.sose.model.AggregatedRatingData;
import it.univaq.disim.sose.model.GlobalScoreData;
import it.univaq.disim.sose.model.RatingData;

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

}
