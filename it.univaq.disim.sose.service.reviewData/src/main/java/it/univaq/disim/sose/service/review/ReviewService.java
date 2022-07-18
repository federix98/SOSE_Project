package it.univaq.disim.sose.service.review;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("review")
public interface ReviewService {

	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getReviewsByUserID")
	String getReviewsByUserID(@QueryParam("userID") int userID) throws SQLException;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getReviewsByFilmID")
	String getReviewsByFilmID(@QueryParam("filmID") int filmID) throws SQLException;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getReviewByFilmIDUserID")
	String getReviewByFilmIDUserID(@QueryParam("filmID")int filmID, @QueryParam("userID")int userID) throws SQLException;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/insertReview")
	String insertReview(@QueryParam("filmID")int filmID, @QueryParam("title") String title, @QueryParam("text") String text, @QueryParam("userID") int userID) throws SQLException;
	
	
	
	
}
