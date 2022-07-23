package it.univaq.disim.sose.service.review;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
		       description = "The description of the getTodos operation goes here!",
				responses = {
			       @ApiResponse(
			          description = "The description of the Response goes here!",
			          content = {
			             @Content(mediaType = MediaType.TEXT_XML, 
			                 array = @ArraySchema(schema = @Schema(implementation = Review.class))),	            		
			             @Content(mediaType = MediaType.APPLICATION_XML,
			                 array = @ArraySchema(schema = @Schema(implementation = Review.class))),
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
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getReviewsByFilmID")
	String getReviewsByFilmID(@QueryParam("filmID") String filmID) throws SQLException;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getReviewByFilmIDUserID")
	String getReviewByFilmIDUserID(@QueryParam("filmID")String filmID, @QueryParam("userID")int userID) throws SQLException;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/insertReview")
	String insertReview(@QueryParam("filmID")String filmID, @QueryParam("title") String title, @QueryParam("text") String text, @QueryParam("userID") int userID) throws SQLException;
	
	
	
}
