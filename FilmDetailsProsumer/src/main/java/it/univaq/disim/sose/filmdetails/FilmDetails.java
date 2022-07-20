package it.univaq.disim.sose.filmdetails;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface FilmDetails {
	
	@WebMethod
	String getFilmDetails(String filmId);
	
}
