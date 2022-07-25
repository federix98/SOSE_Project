package it.univaq.disim.sose.search;

import java.io.IOException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.univaq.disim.sose.search.model.Result;


@WebService
public interface Search {
	@WebMethod
	List<Result> searchFilmsByName(String a) throws IOException;
	
	List<Result> searchOnlyFilms(String a);
	
	List<Result> searchOnlySeries(String a);
	
	List<Result> searchEpisodes(String a);

}
