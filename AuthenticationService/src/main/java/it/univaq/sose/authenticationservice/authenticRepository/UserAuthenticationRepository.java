
package it.univaq.sose.authenticationservice.authenticRepository;

import it.univaq.sose.authenticationservice.userinfo.User;


public class UserAuthenticationRepository {
	private static User[] Users= {
			new User("1","scholastiqueu","4526","Scholastique","Uwizeyimana","schola.uwizeye@student.univaq.it"),
			new User("2","alexdimateo","4527","Alessandro","Di Mateo","alex.dimateo@student.univaq.it"),
			new User("3","federicodimena","4528","Federico","Di Mena","dimena@student.univaq.it"),
			new User("4","gianlucalea","4529","Gianluca","Lea","gianluca.lea@student.univaq.it")};

	public static synchronized User getUser(String Id) throws  AuthenticationRepositoryException
	{
		for (User user:Users) {
			if(user.getId().equals(Id)) {
				return user;
			}
		}
		throw new AuthenticationRepositoryException("Invalid user ID!");
	  
	}
	
	public static synchronized User getUserByUsername(String username) throws  AuthenticationRepositoryException
	{
		for (User user:Users) {
			if(user.getName().equals(username)) {
				return user;
			}
		}
		throw new AuthenticationRepositoryException("Invalid user ID!");
	  
	}
}
	

	


