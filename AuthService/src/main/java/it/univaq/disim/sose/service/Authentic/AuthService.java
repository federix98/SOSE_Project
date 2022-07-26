package it.univaq.disim.sose.service.Authentic;


import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("User")
public interface AuthService {



	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/Login")
	String login(@QueryParam("username") String username, @QueryParam("password") String password ) throws SQLException;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/signup")
	String signup(@QueryParam("username") String username, @QueryParam("password") String password ) throws SQLException;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/checkUser")
	String checkUser(@QueryParam("userID") int userID, @QueryParam("userToken") String userToken) throws SQLException;
	
	
	
	

	
	
	
}
