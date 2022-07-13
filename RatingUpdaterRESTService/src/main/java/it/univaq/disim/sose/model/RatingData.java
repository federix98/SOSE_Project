package it.univaq.disim.sose.model;

public class RatingData {

	// Keys
	private int film_id;
	private int user_id;
	
	// Parameters
	private int film_direction_rating;
	private int actors_rating;
	private int global_score_rating;
	private int dialogues_rating;
	private int costumer_rating;
	
	
	
	public RatingData(int film_id, int user_id, int film_direction_rating, int actors_rating, int global_score_rating,
			int dialogues_rating, int costumer_rating) {
		super();
		this.film_id = film_id;
		this.user_id = user_id;
		this.film_direction_rating = film_direction_rating;
		this.actors_rating = actors_rating;
		this.global_score_rating = global_score_rating;
		this.dialogues_rating = dialogues_rating;
		this.costumer_rating = costumer_rating;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFilm_direction_rating() {
		return film_direction_rating;
	}
	public void setFilm_direction_rating(int film_direction_rating) {
		this.film_direction_rating = film_direction_rating;
	}
	public int getActors_rating() {
		return actors_rating;
	}
	public void setActors_rating(int actors_rating) {
		this.actors_rating = actors_rating;
	}

	public int getGlobal_score_rating() {
		return global_score_rating;
	}

	public void setGlobal_score_rating(int global_score_rating) {
		this.global_score_rating = global_score_rating;
	}

	public int getDialogues_rating() {
		return dialogues_rating;
	}

	public void setDialogues_rating(int dialogues_rating) {
		this.dialogues_rating = dialogues_rating;
	}

	public int getCostumer_rating() {
		return costumer_rating;
	}

	public void setCostumer_rating(int costumer_rating) {
		this.costumer_rating = costumer_rating;
	}
	
	
}
