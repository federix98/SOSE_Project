package it.univaq.disim.sose.model;

public class RatingData {

	// Keys
	private String filmId;
	private int userId;
	
	// Parameters
	private int filmDirectionRating;
	private int actorsRating;
	private int globalScoreRating;
	private int dialoguesRating;
	private int costumerRating;
	
	public RatingData() {
		
	}
	
	public RatingData(String filmId, int userId, int filmDirectionRating, int actorsRating, int globalScoreRating,
			int dialoguesRating, int costumerRating) {
		super();
		this.filmId = filmId;
		this.userId = userId;
		this.filmDirectionRating = filmDirectionRating;
		this.actorsRating = actorsRating;
		this.globalScoreRating = globalScoreRating;
		this.dialoguesRating = dialoguesRating;
		this.costumerRating = costumerRating;
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


	@Override
	public String toString() {
		return "RatingData [filmId=" + filmId + ", userId=" + userId + ", filmDirectionRating=" + filmDirectionRating
				+ ", actorsRating=" + actorsRating + ", globalScoreRating=" + globalScoreRating + ", dialoguesRating="
				+ dialoguesRating + ", costumerRating=" + costumerRating + "]";
	}
	
	
	
}
