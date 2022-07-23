package it.univaq.sose.authenticationservice.api.token;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="User")
public class UserToken {
	private String Username;
	private String Password;
  
public String getUsername(){
	return Username;
	}
public void setUsername(String username) {
	this.Username=username;
}
public String getPassword(){
	return Password;
	}
public void setPassword(String Password) {
	this.Password=Password;
}

}

