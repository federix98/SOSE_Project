package it.univaq.disim.sose.ratingupdater.data;

import java.util.List;

import it.univaq.disim.sose.ratingupdater.model.RatingData;

public interface RatingDataDAO {

	boolean insertRatingData(RatingData toAdd);
	
	boolean insertRatingDatas(List<RatingData> toAdd);
	
	List<RatingData> getAllRatingData();
	
	List<RatingData> getAllRatingDataByFilmId(String filmId);
	
}
