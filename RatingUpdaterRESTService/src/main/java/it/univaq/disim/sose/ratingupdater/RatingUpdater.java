package it.univaq.disim.sose.ratingupdater;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.*;

@Path("/ratingupdaterservice")
public interface RatingUpdater {
	
	@GET
	@Path("/addRatingsAsync")
	@Produces({MediaType.APPLICATION_JSON})
	void addRatingsAsync(
			@PathParam("userId") int userId,
			@PathParam("filmId") String filmId,
			@PathParam("filmDirectionRating") int filmDirectionRating,
			@PathParam("actorsRating") int actorsRating,
			@PathParam("globalScoreRating") int globalScoreRating,
			@PathParam("dialoguesRating") int dialoguesRating,
			@PathParam("costumesRating") int costumesRating,
			@Suspended final AsyncResponse asyncResponse) throws Exception;
	
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
	
	@GET
	@Path("/getGlobalScore")
	@Produces({MediaType.APPLICATION_JSON})
	String getGlobalScore(@QueryParam("filmId") String filmId);
}
