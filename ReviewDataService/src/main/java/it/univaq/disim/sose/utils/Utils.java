package it.univaq.disim.sose.utils;


public class Utils {
	
	
	public static String buildXMLResponse(String xmlToAdd) {
		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xmlToAdd;
		return response;
	}

}
