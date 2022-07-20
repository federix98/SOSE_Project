package it.univaq.disim.sose.ratingupdater.data;

import it.univaq.disim.sose.ratingupdater.model.GlobalScoreData;

public interface GlobalScoreDAO {
	
	GlobalScoreData readGlobalScore(String filmId);
	
	boolean updateGlobalScore(GlobalScoreData newValue);
	
}
