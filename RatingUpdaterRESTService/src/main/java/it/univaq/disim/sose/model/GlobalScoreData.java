package it.univaq.disim.sose.model;

public class GlobalScoreData {

	private int film_id;
	private double global_score;
	private int number_of_ratings;
	
	public GlobalScoreData(int film_id, double global_score, int number_of_ratings) {
		super();
		this.film_id = film_id;
		this.global_score = global_score;
		this.number_of_ratings = number_of_ratings;
	}
	
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public double getGlobal_score() {
		return global_score;
	}
	public void setGlobal_score(double global_score) {
		this.global_score = global_score;
	}
	public int getNumber_of_ratings() {
		return number_of_ratings;
	}
	public void setNumber_of_ratings(int number_of_ratings) {
		this.number_of_ratings = number_of_ratings;
	}
	
	
	
}
