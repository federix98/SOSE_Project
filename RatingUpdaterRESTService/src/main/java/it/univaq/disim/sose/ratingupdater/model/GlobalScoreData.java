package it.univaq.disim.sose.ratingupdater.model;

public class GlobalScoreData {

	private String filmId;
	private double globalScore;
	private int numberOfRatings;
	
	public GlobalScoreData(String filmId, double globalScore, int numberOfRatings) {
		super();
		this.filmId = filmId;
		this.globalScore = globalScore;
		this.numberOfRatings = numberOfRatings;
	}

	public String getFilmId() {
		return filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public double getGlobalScore() {
		return globalScore;
	}

	public void setGlobalScore(double globalScore) {
		this.globalScore = globalScore;
	}

	public int getNumberOfRatings() {
		return numberOfRatings;
	}

	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	@Override
	public String toString() {
		return "GlobalScoreData [filmId=" + filmId + ", globalScore=" + globalScore + ", numberOfRatings="
				+ numberOfRatings + "]";
	}
	
	
	
}
