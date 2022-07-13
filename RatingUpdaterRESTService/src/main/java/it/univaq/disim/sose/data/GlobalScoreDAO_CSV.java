package it.univaq.disim.sose.data;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import it.univaq.disim.sose.model.GlobalScoreData;

public class GlobalScoreDAO_CSV implements GlobalScoreDAO {

	private static String[] HEADERS = { "film_id", "global_score", "number_of_ratings"};
	private static String STORAGE_FILE_PATH = "/Users/federico/Desktop/Università/COURSE - Service Oriented Software Engineering/eclipse-ws/sose-workspace/RatingUpdaterRESTService/src/main/resources/data/globalscore_data.csv";
	
	
	@Override
	public GlobalScoreData readGlobalScore(int filmId) {
		try {
			Reader in = new FileReader(STORAGE_FILE_PATH);
		    Iterable<CSVRecord> records;
			records = CSVFormat.DEFAULT
			  .withHeader(HEADERS)
			  .withFirstRecordAsHeader()
			  .parse(in);
		    
		    for (CSVRecord record : records) {
		    	if (Integer.parseInt(record.get(HEADERS[0])) == filmId) {
		    		return new GlobalScoreData(
		    				Integer.parseInt(record.get(HEADERS[0])),
		    				Double.parseDouble(record.get(HEADERS[1])),
		    				Integer.parseInt(record.get(HEADERS[2]))
		    				);
		    	}
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void removeIfExists(int FilmId) {
		
	}

	@Override
	public boolean updateGlobalScore(GlobalScoreData newScore) {
		try {
			
			removeIfExists(newScore.getFilm_id());
			
        	File file = new File(STORAGE_FILE_PATH);
    		FileWriter out = new FileWriter(file, true);
        	if (file.length() == 0) {
    			out.append(String.join(",", HEADERS));
    		}
        	try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT)) {
				printer.printRecord(
						newScore.getFilm_id(), 
						newScore.getGlobal_score(), 
						newScore.getNumber_of_ratings()
						);
				printer.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    return true;
	}

}
