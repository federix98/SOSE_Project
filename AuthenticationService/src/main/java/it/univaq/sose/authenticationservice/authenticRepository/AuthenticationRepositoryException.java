package it.univaq.sose.authenticationservice.authenticRepository;

public class AuthenticationRepositoryException extends Exception{
	private static final long serialVersionUID=1L;
	
	public AuthenticationRepositoryException() {
		super();
	}
	
	public AuthenticationRepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message,cause,enableSuppression,writableStackTrace);
	}
	
	public AuthenticationRepositoryException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public AuthenticationRepositoryException(String message) {
		super(message);
	}
	
	public AuthenticationRepositoryException(Throwable cause) {
		super(cause);
	}

}
