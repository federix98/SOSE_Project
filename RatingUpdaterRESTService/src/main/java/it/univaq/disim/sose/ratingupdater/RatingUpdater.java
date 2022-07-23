package it.univaq.disim.sose.ratingupdater;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.disim.sose.ratingupdater.model.RatingData;

@Path("/ratingupdaterservice")
public interface RatingUpdater {

	@Operation( 
		       description = "Add Rating by specifing some fields",
				responses = {
			       @ApiResponse(
			          description = "Return Inserted or not if it has been already inserted a rating",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON)
			          }
			       )
			    }
			 )	
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
	
	
	@Operation( 
		       description = "Get average rating for a film",
				responses = {
			       @ApiResponse(
			          description = "Return the average rating as Json response",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON)
			          }
			       )
			    }
			 )	
	@GET
	@Path("/getRatingAvgs")
	@Produces({MediaType.APPLICATION_JSON})
	String getRatingAvgs(
			@QueryParam("filmId") String filmId);
	
	
	
	
	@Operation( 
		       description = "Get all the ratings inserted for a Film",
				responses = {
			       @ApiResponse(
			          description = "Return all the ratings as a Json response",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON,
			                		 array = @ArraySchema(schema = @Schema(implementation = RatingData.class))
			                )
			          }
			       )
			    }
			 )	
	
	@GET
	@Path("/getAllRatings")
	@Produces({MediaType.APPLICATION_JSON})
	String getAllRatings(@QueryParam("filmId") String filmId);
}
