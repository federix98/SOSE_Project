package it.univaq.disim.sose.service.Authentic;


import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@Path("User")
public interface AuthService {



	@Operation( 
		       description = "Login operation by specifying username and password",
				responses = {
			       @ApiResponse(
			          description = "Return the Token for the user logged",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON)
			          }
			       )
			    }
			 )
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/Login")
	String login(@FormParam("username") String username, @FormParam("password") String password ) throws SQLException;
	
	
	@Operation( 
		       description = "Signup operation by specifying username and password",
				responses = {
			       @ApiResponse(
			          description = "Return the id for the registered user",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON)
			          }
			       )
			    }
			 )
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/signup")
	String signup(@FormParam("username") String username, @FormParam("password") String password ) throws SQLException;
	
	
	@Operation( 
		       description = "Check the token of the user by specifying userID and userToken",
				responses = {
			       @ApiResponse(
			          description = "Return true if logged, false otherwise",
			          content = {
			                 @Content(mediaType = MediaType.APPLICATION_JSON)
			          }
			       )
			    }
			 )
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/checkUser")
	String checkUser(@FormParam("userID") int userID, @FormParam("userToken") String userToken) throws SQLException;

		
	
	
	
}
