package it.univaq.disim.sose.filmdetails;

import it.univaq.disim.sose.filmdetails.data.IMDBRestClient;
import it.univaq.disim.sose.filmdetails.data.RatingDataClient;
import it.univaq.disim.sose.filmdetails.data.ReviewDataClient;
import it.univaq.disim.sose.model.FilmData;

public class FilmDetailsImpl implements FilmDetails {

	@Override
	public FilmData getFilmDetails(String filmId) {
		// TODO Auto-generated method stub
		
		// Chiama realmente IMDB Api
		// IMDBRestClient.getFilmData(filmId);
		
		/**
		 * Per non sprecare chiamate IMDB utilizzare
		 * il seguente metodo. Questo ritornerà sempre
		 * i dati della serie tv Lost
		 */
		FilmData filmData = IMDBRestClient.getFilmDataSimulated(filmId);
		
		filmData.setRatings(RatingDataClient.getRatingData(filmId));
		
		filmData.setReviews(ReviewDataClient.getReviewData(filmId).getList());
		
		// System.out.println(filmData.getReviews().size());

		return filmData;
	}

}
