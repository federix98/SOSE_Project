package it.univaq.disim.sose.filmdetails;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.univaq.disim.sose.model.FilmData;

@WebService
public interface FilmDetails {
	
	@WebMethod
	FilmData getFilmDetails(String filmId);
	
}
