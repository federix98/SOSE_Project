package it.univaq.disim.sose.callbacks;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;

import it.univaq.disim.sose.utils.Utility;

public class Callback implements InvocationCallback<Response>{

	private String messageFromTheServer;
	
	@Override
	public void completed(Response response) {
		// TODO Auto-generated method stub
		if (response.getStatus() == 200) {
			messageFromTheServer = response.readEntity(String.class);
		}
		else {
			Utility.consoleLog("REQUEST ERROR - " + response.getStatus());
		}
		
	}

	@Override
	public void failed(Throwable throwable) {
		// TODO Auto-generated method stub
		throwable.printStackTrace();
	}
	
	public String getResponse() {
		return this.messageFromTheServer;
	}

}
