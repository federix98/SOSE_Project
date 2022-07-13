package it.univaq.disim.sose.data;

import java.util.List;

import it.univaq.disim.sose.model.RatingData;

public interface RatingDataDAO {

	boolean insertRatingData(RatingData toAdd);
	
	boolean insertRatingDatas(List<RatingData> toAdd);
	
	List<RatingData> getAllRatingData();
	
}
