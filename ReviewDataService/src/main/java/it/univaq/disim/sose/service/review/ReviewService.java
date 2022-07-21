package it.univaq.disim.sose.service.review;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("Review")
public interface ReviewService {

	
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
