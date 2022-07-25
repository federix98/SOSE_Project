package it.univaq.disim.sose.model;

public class AggregatedRatingData {

	// Keys
	private String filmId;
	private int userId;
	
	// Parameters
	private int filmDirectionRating;
	private int actorsRating;
	private int globalScoreRating;
	private int dialoguesRating;
	private int costumerRating;
	
	private double globalScore;
	private int numberOfRatings;
	
	
	
	public AggregatedRatingData(String filmId, int userId, int filmDirectionRating, int actorsRating,
			int globalScoreRating, int dialoguesRating, int costumerRating, double globalScore, int numberOfRatings) {
		super();
		this.filmId = filmId;
		this.userId = userId;
		this.filmDirectionRating = filmDirectionRating;
		this.actorsRating = actorsRating;
		this.globalScoreRating = globalScoreRating;
		this.dialoguesRating = dialoguesRating;
		this.costumerRating = costumerRating;
		this.globalScore = globalScore;
		this.numberOfRatings = numberOfRatings;
	}

	public AggregatedRatingData() {
		super();
	}

	public String getFilmId() {
		return filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFilmDirectionRating() {
		return filmDirectionRating;
	}

	public void setFilmDirectionRating(int filmDirectionRating) {
		this.filmDirectionRating = filmDirectionRating;
	}

	public int getActorsRating() {
		return actorsRating;
	}

	public void setActorsRating(int actorsRating) {
		this.actorsRating = actorsRating;
	}

	public int getGlobalScoreRating() {
		return globalScoreRating;
	}

	public void setGlobalScoreRating(int globalScoreRating) {
		this.globalScoreRating = globalScoreRating;
	}

	public int getDialoguesRating() {
		return dialoguesRating;
	}

	public void setDialoguesRating(int dialoguesRating) {
		this.dialoguesRating = dialoguesRating;
	}

	public int getCostumerRating() {
		return costumerRating;
	}

	public void setCostumerRating(int costumerRating) {
		this.costumerRating = costumerRating;
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
		return "AggregatedRatingData [filmId=" + filmId + ", userId=" + userId + ", filmDirectionRating="
				+ filmDirectionRating + ", actorsRating=" + actorsRating + ", globalScoreRating=" + globalScoreRating
				+ ", dialoguesRating=" + dialoguesRating + ", costumerRating=" + costumerRating + ", globalScore="
				+ globalScore + ", numberOfRatings=" + numberOfRatings + "]";
	}
	
}
