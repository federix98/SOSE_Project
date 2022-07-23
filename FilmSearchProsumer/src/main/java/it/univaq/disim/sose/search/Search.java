package it.univaq.disim.sose.search;

import java.net.ProtocolException;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Search {
	@WebMethod
	String searchFilmsByName(String a) throws ProtocolException;
	
	String searchOnlyFilms(String a);
	
	String searchOnlySeries(String a);
	
	String searchEpisodes(String a);

}
