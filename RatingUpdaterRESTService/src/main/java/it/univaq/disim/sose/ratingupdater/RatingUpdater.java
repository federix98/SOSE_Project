package it.univaq.disim.sose.ratingupdater;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/ratingupdaterservice")
public interface RatingUpdater {
	
	@GET
	@Path("/addRatings")
	@Produces({MediaType.APPLICATION_JSON})
	String addRatings(
			@QueryParam("userId") int userId,
			@QueryParam("filmId") String filmId,
			@QueryParam("filmDirectionRating") int filmDirectionRating,
			@QueryParam("actorsRating") int actorsRating,
			@QueryParam("globalScoreRating") int globalScoreRating,
			@QueryParam("dialoguesRating") int dialoguesRating,
			@QueryParam("costumesRating") int costumesRating);
	
	@GET
	@Path("/getRatingAvgs")
	@Produces({MediaType.APPLICATION_JSON})
	String getRatingAvgs(
			@QueryParam("filmId") String filmId);
	
	@GET
	@Path("/getAllRatings")
	@Produces({MediaType.APPLICATION_JSON})
	String getAllRatings(@QueryParam("filmId") String filmId);
}
