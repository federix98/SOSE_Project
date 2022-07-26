package it.univaq.disim.sose.filmdetails;

import java.util.concurrent.Future;

import javax.xml.ws.Response;

import it.univaq.disim.sose.filmdetails.data.IMDBRestClient;
import it.univaq.disim.sose.filmdetails.data.RatingDataClient;
import it.univaq.disim.sose.filmdetails.data.ReviewDataClient;
import it.univaq.disim.sose.model.AggregatedRatingData;
import it.univaq.disim.sose.model.FilmData;
import it.univaq.disim.sose.service.AggregateRatingsResponse;
import it.univaq.disim.sose.service.FilmDetailsAggregator;
import it.univaq.disim.sose.service.FilmDetailsAggregatorImplService;
import it.univaq.disim.sose.util.MessageAsyncHandler;
import it.univaq.disim.sose.util.Utility;

public class FilmDetailsImpl implements FilmDetails {

	@Override
	public FilmData getFilmDetails(String filmId) throws Exception{
		// TODO Auto-generated method stub
		
		// Chiama realmente IMDB Api
		// IMDBRestClient.getFilmData(filmId);
		
		/**
		 * Per non sprecare chiamate IMDB utilizzare
		 * il seguente metodo. Questo ritornerà sempre
		 * i dati della serie tv Lost
		 */
		
		FilmData filmData = new FilmData();
		boolean othersDone = false;
		// filmData.setRatings(RatingDataClient.getRatingData(filmId));
		
		
		FilmDetailsAggregatorImplService service = new FilmDetailsAggregatorImplService();
		FilmDetailsAggregator port = service.getFilmDetailsAggregatorImplPort();
		
		MessageAsyncHandler messageAsyncHandler = new MessageAsyncHandler();
		
		Future<?> response = port.aggregateRatingsAsync(filmId, messageAsyncHandler);
		
		while (!response.isDone()) {
			Utility.consoleLog("Still waiting for aggregateRatingsAsync");
			
			
			
			if (!othersDone) {
				filmData = IMDBRestClient.getFilmDataSimulated(filmId);
				filmData.setReviews(ReviewDataClient.getReviewData(filmId).getList());
				othersDone = true;
			}
			
			Thread.sleep(1000);
		}
		
		Utility.consoleLog("aggregateRatingsAsync replied");
		
		filmData.setRatings(new AggregatedRatingData(messageAsyncHandler.getAggregateRatingsResponse().getReturn()));
		
		
		
		// System.out.println(filmData.getReviews().size());

		return filmData;
	}

}
