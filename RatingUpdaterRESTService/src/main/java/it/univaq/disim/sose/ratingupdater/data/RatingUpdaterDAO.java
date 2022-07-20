package it.univaq.disim.sose.ratingupdater.data;

public class RatingUpdaterDAO {

	private static RatingUpdaterDAO instance;
	
	private RatingDataDAO ratingDataDAO;
	private GlobalScoreDAO globalScoreDAO;
	
	private RatingUpdaterDAO() {
		this.ratingDataDAO = new RatingDataDAO_SQLLite();
		this.globalScoreDAO = new GlobalScoreDAO_SQLLite();
	}
	
	public static RatingUpdaterDAO getInstance() {
		if (instance == null) instance = new RatingUpdaterDAO();
		return instance;
	}
	
	public RatingDataDAO getRatingDataDAO() {
		return this.ratingDataDAO;
	}
	
	public GlobalScoreDAO getGlobalScoreDAO() {
		return this.globalScoreDAO;
	}
	
}
