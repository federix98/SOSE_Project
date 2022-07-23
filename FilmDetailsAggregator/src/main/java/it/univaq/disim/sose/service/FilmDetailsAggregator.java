package it.univaq.disim.sose.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.univaq.disim.sose.model.RatingData;

@WebService
public interface FilmDetailsAggregator {

	@WebMethod
	RatingData aggregateRatings(String filmId);
	
}
