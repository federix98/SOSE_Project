package it.univaq.disim.sose.ratingupdater.data;

import java.sql.SQLException;
import java.util.List;

import it.univaq.disim.sose.ratingupdater.model.RatingData;

public interface RatingDataDAO {

	boolean insertRatingData(RatingData toAdd) throws SQLException;
	
	boolean insertRatingDatas(List<RatingData> toAdd) throws SQLException;
	
	List<RatingData> getAllRatingData() throws SQLException;
	
	List<RatingData> getAllRatingDataByFilmId(String filmId) throws SQLException;
	
}
