package it.univaq.disim.sose.search.model;

public class Result {
	
	String id,description,title,image;
	
	public Result() {
	}
	
	public Result(String id, String description,String title,String image) {
		this.id = id;
		this.description = description;
		this.title=title;
		this.image=image;
	}
	
	public String getDescription() {
		return description;
	}
	public String getId() {
		return id;
	}
	public String getImage() {
		return image;
	}
	public String getTitle() {
		return title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

}
