package it.univaq.disim.sose.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewList {
	
	private List<Review> list;
	
	public ReviewList(){
        this.list = new ArrayList<>();
    }

    public ReviewList(List<Review> reviewList){
        this.list = reviewList;
    }

    public void add(Review review){
        list.add(review);
    }
    
    public List<Review> getList() {
    	return this.list;
    }
    
    public String toString() {
    	return list.stream()
        .map(n -> n.toString())
        .collect(Collectors.joining("-", "{", "}"));
    }
    
    

}
