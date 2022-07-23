package it.univaq.disim.sose.data;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;

public class AuthDataClient {

	private static final String AuthServiceUrl = "http://localhost:8080/AuthService/rest/Auth/checkToken";
	
	public static String checkToken(String userToken) {
		
		WebClient client = WebClient.create(AuthServiceUrl 
				+ "?token=" + userToken);
				
				
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		JSONObject jsonObject = new JSONObject(response.readEntity(String.class));
		
		return jsonObject.getString("Response");
		
		
	}

}
