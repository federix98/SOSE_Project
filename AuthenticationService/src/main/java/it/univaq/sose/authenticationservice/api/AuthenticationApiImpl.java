package it.univaq.sose.authenticationservice.api;

import javax.ws.rs.WebApplicationException;
import it.univaq.sose.authenticationservice.api.token.UserToken;
import it.univaq.sose.authenticationservice.api.token.WebToken;
import it.univaq.sose.authenticationservice.authenticRepository.AuthenticationRepositoryException;
import it.univaq.sose.authenticationservice.authenticate.AuthenticationException;
import it.univaq.sose.authenticationservice.authenticate.AuthenticationService;

public class AuthenticationApiImpl implements AuthenticationApi {
	@Override
	public WebToken login(UserToken User) throws Exception {
		try {
			return AuthenticationService.login(User);
		}
		catch(AuthenticationException|AuthenticationRepositoryException e){
			throw new WebApplicationException(401);
			
		}
		catch(Exception e) {
			throw new WebApplicationException(500);
		}
		}
	@Override

	public Boolean checkJwt(String Jwt) {
		System.out.println(Jwt);
		if(AuthenticationService.checkJwt(Jwt)) {
		return true;
	}
		else {
			throw new WebApplicationException(401);
			}
		}

}
