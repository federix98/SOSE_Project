package it.univaq.disim.sose.util;

import java.util.List;

import com.thoughtworks.xstream.XStream;

import it.univaq.disim.sose.model.FilmData;
import it.univaq.disim.sose.model.Review;
import it.univaq.disim.sose.model.ReviewList;

public class Utility {

	public static String buildXMLResponse(FilmData obj) {
		XStream xstream = new XStream();
		String xmlToAdd = xstream.toXML(obj);
		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xmlToAdd;
		return response;
	}
	
}
