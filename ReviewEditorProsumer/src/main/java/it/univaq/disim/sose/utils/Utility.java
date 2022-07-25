package it.univaq.disim.sose.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	
	public static void consoleLog(String message) {
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		String whoAmI = "ReviewEditorProsumer";
		System.out.println(whoAmI + " [" + now + "] " + message);
	}
	
}
