package it.univaq.disim.sose.data;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import it.univaq.disim.sose.model.RatingData;

public class RatingDataDAO_CSV implements RatingDataDAO {
	
	private static String[] HEADERS = { "film_id", "user_id", "film_direction_rating", "actors_rating", "global_score_rating", "dialogues_rating", "costumes_rating"};
	private static String STORAGE_FILE_PATH = "/Users/federico/Desktop/Università/COURSE - Service Oriented Software Engineering/eclipse-ws/sose-workspace/RatingUpdaterRESTService/src/main/resources/data/rating_data.csv";
	
	@Override
	public boolean insertRatingData(RatingData toAdd) {
		
        try {
        	File file = new File(STORAGE_FILE_PATH);
    		FileWriter out = new FileWriter(file, true);
        	if (file.length() == 0) {
    			out.append(String.join(",", HEADERS));
    		}
        	CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT);
			printer.printRecord(
					toAdd.getFilm_id(), 
					toAdd.getUser_id(), 
					toAdd.getFilm_direction_rating(), 
					toAdd.getActors_rating(), 
					toAdd.getGlobal_score_rating(), 
					toAdd.getDialogues_rating(), 
					toAdd.getCostumer_rating());
			printer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    return true;
	}

	@Override
	public boolean insertRatingDatas(List<RatingData> toAdd) {
		// TODO Auto-generated method stub
		try {
			
        	File file = new File(STORAGE_FILE_PATH);
    		FileWriter out = new FileWriter(file, true);
        	
    		
    		if (file.length() == 0) {
    			CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(HEADERS));
            	toAdd.forEach((element) -> {
            		try {
    					printer.printRecord(
    							element.getFilm_id(), 
    							element.getUser_id(), 
    							element.getFilm_direction_rating(), 
    							element.getActors_rating(), 
    							element.getGlobal_score_rating(), 
    							element.getDialogues_rating(), 
    							element.getCostumer_rating());
    					printer.flush();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            	});
    		}
    		else {
    			CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT);
            	toAdd.forEach((element) -> {
            		try {
    					printer.printRecord(
    							element.getFilm_id(), 
    							element.getUser_id(), 
    							element.getFilm_direction_rating(), 
    							element.getActors_rating(), 
    							element.getGlobal_score_rating(), 
    							element.getDialogues_rating(), 
    							element.getCostumer_rating());
    					printer.flush();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            	});
    		}
        	
        	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    return true;
	}

	@Override
	public List<RatingData> getAllRatingData() {
		
		try {
			Reader in = new FileReader(STORAGE_FILE_PATH);
		    Iterable<CSVRecord> records;
			records = CSVFormat.DEFAULT
			  .withHeader(HEADERS)
			  .withFirstRecordAsHeader()
			  .parse(in);
			List<RatingData> readData = new ArrayList<RatingData>();
		    
		    for (CSVRecord record : records) {
		    	readData.add(
		    			new RatingData(
		    					Integer.parseInt(record.get(HEADERS[0])),
		    					Integer.parseInt(record.get(HEADERS[1])),
		    					Integer.parseInt(record.get(HEADERS[2])),
		    					Integer.parseInt(record.get(HEADERS[3])),
		    					Integer.parseInt(record.get(HEADERS[4])),
		    					Integer.parseInt(record.get(HEADERS[5])),
		    					Integer.parseInt(record.get(HEADERS[6]))
		    					)
		    			);
		    }
			return readData;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}
