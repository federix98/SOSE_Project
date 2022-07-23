package it.univaq.sose.authenticationservice.api.token;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Jwt")
public class WebToken {
	private String TokenId;
	private Date ExpiredDate;
	private String ID;
	
	public WebToken() {
		super();
	}
	
	public WebToken(String TokenId,Date ExpiredDate,String ID) {
		super();
		this.TokenId=TokenId;
		this.ExpiredDate=ExpiredDate;
		this.ID=ID;
	}
	public String getTokenId() {
		return TokenId;
		
	}
	
	public void setTokenId(String TokenId) {
		this.TokenId=TokenId;
	}
	
	public Date getExpiredDate() {
		return ExpiredDate;
		
	}
	
	public void setExpiredDate(Date ExpiredDate) {
		this.ExpiredDate=ExpiredDate;
	}
	
	public String getID() {
		return ID;
		
	}
	
	public void setID(String ID) {
		this.ID=ID;
	}
	
	

}
