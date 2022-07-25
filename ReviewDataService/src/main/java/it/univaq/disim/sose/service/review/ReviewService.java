package it.univaq.disim.sose.service.review;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.disim.sose.model.Review;

@Path("Review")
public interface ReviewService {

	
	@Operation( 
		       description = "Get all the reviews inserted by a User",
				responses = {
			       @ApiResponse(
			          description = "Return all the reviews as a Json response",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON,
			                 array = @ArraySchema(schema = @Schema(implementation = Review.class)))
			          }
			       )
			    }
			 )	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getReviewsByUserID")
	String getReviewsByUserID(@QueryParam("userID") int userID) throws SQLException;
	
	
	
	
	@Operation( 
		       description = "Get all the reviews by FilmID",
				responses = {
			       @ApiResponse(
			          description = "Return all the reviews as a Json response",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON,
			                 array = @ArraySchema(schema = @Schema(implementation = Review.class)))
			          }
			       )
			    }
			 )
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getReviewsByFilmID")
	String getReviewsByFilmID(@QueryParam("filmID") String filmID) throws SQLException;
	
	
	
	
	
	
	@Operation( 
		       description = "Get Review inserted by a User for a specific film",
				responses = {
			       @ApiResponse(
			          description = "Return all the reviews as a Json response",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON,
			                 array = @ArraySchema(schema = @Schema(implementation = Review.class)))
			          }
			       )
			    }
			 )
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getReviewByFilmIDUserID")
	String getReviewByFilmIDUserID(@QueryParam("filmID")String filmID, @QueryParam("userID")int userID) throws SQLException;
	
	
	
	
	
	@Operation( 
		       description = "Insert review by specifing some parameters",
				responses = {
			       @ApiResponse(
			          description = "Return Inserted if the user has not inserted already a review for the film, otherwise return not inserted",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON)
			          }
			       )
			    }
			 )
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/insertReview")
	String insertReview(@QueryParam("filmID")String filmID, @QueryParam("title") String title, @QueryParam("text") String text, @QueryParam("userID") int userID) throws SQLException;
	
	
	@Operation( 
		       description = "Insert review by specifing some parameters async",
				responses = {
			       @ApiResponse(
			          description = "Return Inserted if the user has not inserted already a review for the film, otherwise return not inserted (async)",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON)
			          }
			       )
			    }
			 )
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/insertReviewAsync")
	void insertReviewAsync(
			@QueryParam("filmID") final String filmID, 
			@QueryParam("title") final String title, 
			@QueryParam("text") final String text, 
			@QueryParam("userID") final int userID, 
			@Suspended final AsyncResponse asyncResponse) throws Exception;
	
	
}
