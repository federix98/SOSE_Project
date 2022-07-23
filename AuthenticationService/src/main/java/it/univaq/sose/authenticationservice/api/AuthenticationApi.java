package it.univaq.sose.authenticationservice.api;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import it.univaq.sose.authenticationservice.api.token.UserToken;
import it.univaq.sose.authenticationservice.api.token.WebToken;
@Path("/login")
public interface AuthenticationApi {
@POST
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public WebToken login(UserToken User) throws Exception;
@GET
@Path("/{jwt}")
public Boolean checkJwt(@PathParam("jwt") String Jwt);
}
