package it.univaq.disim.sose.data;

import it.univaq.disim.sose.model.GlobalScoreData;

public interface GlobalScoreDAO {
	
	GlobalScoreData readGlobalScore(int filmId);
	
	boolean updateGlobalScore(GlobalScoreData newValue);
	
}
