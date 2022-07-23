package it.univaq.disim.sose.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class FilmData {

	
	// IMDB Data
	private String id;
	private String title;
	private String originalTitle;
	private String fullTitle;
	private String imageLink;
	private String description;
	private String type;
	private String year;
	private String releaseDate;
	private String stars;
	private String awards;
	private String genres;
	private String companies;
	private String countries;
	private String languages;
	
	// Reviews
	// model review
	private List<Review> reviews;
	
	// Ranking
	// model rating
	private RatingData ratings;
	
	public FilmData() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getCompanies() {
		return companies;
	}

	public void setCompanies(String companies) {
		this.companies = companies;
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	

	public RatingData getRatings() {
		return ratings;
	}

	public void setRatings(RatingData ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "FilmData [id=" + id + ", title=" + title + ", originalTitle=" + originalTitle + ", fullTitle="
				+ fullTitle + ", imageLink=" + imageLink + ", description=" + description + ", type=" + type + ", year="
				+ year + ", releaseDate=" + releaseDate + ", stars=" + stars + ", awards=" + awards + ", genres="
				+ genres + ", companies=" + companies + ", countries=" + countries + ", languages=" + languages
				+ ", reviews=" + reviews + ", ratings=" + ratings + "]";
	}
	
	
	
	
	
}
