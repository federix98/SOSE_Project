
package it.univaq.sose.authenticationservice.api;

import javax.crypto.SecretKey;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class AuthenticationKey {
	public static final SecretKey key= Keys.secretKeyFor(SignatureAlgorithm.HS256); 
}
