package it.univaq.disim.sose.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	
	public static String getResourcesPath() {
		//File directory = new File("./");
		// System.out.println(Utils.class.getResource(".").toString());
		URL resource = Utils.class.getClassLoader().getResource("sqlite");
		consoleLog(resource.toString());
		// URL resource = Utils.class.getResource("sqlite");
		String resourcesPath;
		try {
			resourcesPath = new File(resource.toURI()).getAbsolutePath();
			return resourcesPath; 
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		
	}
	
	public static String buildXMLResponse(String xmlToAdd) {
		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xmlToAdd;
		return response;
	}
	
	public static void consoleLog(String message) {
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		String whoAmI = "ReviewDataService";
		System.out.println(whoAmI + " [" + now + "] " + message);
	}

}
