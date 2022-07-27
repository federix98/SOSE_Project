package it.univaq.disim.sose.service;

import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.ResponseWrapper;

import it.univaq.disim.sose.model.AggregatedDataResponse;
import it.univaq.disim.sose.model.AggregatedRatingData;

@WebService
public interface FilmDetailsAggregator {

	@WebMethod
	AggregatedRatingData aggregateRatings(String filmId);
	
	@WebMethod
	@ResponseWrapper(
			localName = "AggregatedDataResponse",
			className = "it.univaq.disim.sose.mode.AggregatedDataResponse"
	)
	public Future<?> aggregateRatingsAsync(String filmId, AsyncHandler<AggregatedDataResponse> asyncHandler);
	
}
