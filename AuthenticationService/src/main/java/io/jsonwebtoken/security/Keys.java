package io.jsonwebtoken.security;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;

public @interface Keys 
	{
		public static final SecretKey key= Keys.secretKeyFor(SignatureAlgorithm.HS256); 
	}

