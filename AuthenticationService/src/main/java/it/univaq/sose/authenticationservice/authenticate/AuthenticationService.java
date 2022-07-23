package it.univaq.sose.authenticationservice.authenticate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.crypto.SecretKey;
import org.apache.cxf.rt.security.claims.Claim;
import it.univaq.sose.authenticationservice.api.token.UserToken;
import it.univaq.sose.authenticationservice.api.token.WebToken;
import it.univaq.sose.authenticationservice.authenticRepository.AuthenticationRepositoryException;
import it.univaq.sose.authenticationservice.authenticRepository.UserAuthenticationRepository;
import it.univaq.sose.authenticationservice.userinfo.User;


public class AuthenticationService {

public static WebToken login(UserToken usetoken) throws AuthenticationRepositoryException, AuthenticationException {

		User user = UserAuthenticationRepository.getUserByUsername(usetoken.getUsername());

		if (user.getPassword().equals(usetoken.getPassword())) {
			return makeJwt(usetoken.getUsername(), user.getId());
		} else {
			throw new AuthenticationException("Wrong password");
		}

	}

	private static WebToken makeJwt(String username, String userId) {
		WebToken webtoken = new WebToken();
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime nowPlusOneMouth = now.plusMonths(1);
		Date currentDatePlusOneMouths = Date.from(nowPlusOneMouth.atZone(ZoneId.systemDefault()).toInstant());
		String token = Jwt.builder().
		setSubject(username).
		setExpiration(currentDatePlusOneMouths).
		signWith(SecretKey.key).
		compact();
		
		webtoken.setID(token);
		webtoken.setExpiredDate(currentDatePlusOneMouths);
		webtoken.setID(userId);
		return webtoken;
		
	}

	public static boolean checkJwt(String jwt) {
		try {
			Claim claims = jwt.parserBuilder().setSigningKey(SecretKey.key).build().parseClaimsJws(jwt).getBody();
			System.out.println( claims.getSubject());
			return true;

		} catch (JwtException e) {
			return false;
		}
	}

}
