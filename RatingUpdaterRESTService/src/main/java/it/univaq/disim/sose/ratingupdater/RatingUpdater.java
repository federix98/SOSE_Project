package it.univaq.disim.sose.ratingupdater;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/ratingupdaterservice")
public interface RatingUpdater {
	
	@GET
	@Path("/add_ratings")
	@Produces({MediaType.TEXT_XML})
	String add_ratings(
			@QueryParam("user_id") int user_id,
			@QueryParam("film_id") int film_id,
			@QueryParam("film_direction_rating") int film_direction_rating,
			@QueryParam("actors_rating") int actors_rating,
			@QueryParam("global_score_rating") int global_score_rating,
			@QueryParam("dialogues_rating") int dialogues_rating,
			@QueryParam("costumes_rating") int costumes_rating);
	
}
