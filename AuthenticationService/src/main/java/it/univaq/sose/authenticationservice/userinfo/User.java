package it.univaq.sose.authenticationservice.userinfo;
import java.util.Objects;


public class User {
	private String Id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;

	public User() {
		super();}
	
	public User(String Id,String username,String password,String name,String surname,String email) 
	{
	super();
	this.Id=Id;
	this.username=username;
	this.password = password;
	this.name=name;
	this.surname=surname;
	this.email=email;
	}
	
	public String getId() {
		return Id;
	}
	
	public void setId(String Id){
		this.Id=Id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username){
		this. username= username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password){
		this. password= password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname){
		this. surname= surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email){
		this. email= email;
	}
	
	@Override
	public String toString() {
		return "User[Id="+ Id + ",username="+ username +",password="+ password +",name="+ name +", surname="+ surname + " ,email="+ email +"]";
		}
	
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(username, other.username);
	}
}
