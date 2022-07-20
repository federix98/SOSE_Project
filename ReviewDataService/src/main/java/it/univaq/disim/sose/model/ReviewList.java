package it.univaq.disim.sose.model;

import java.util.List;

public class ReviewList {
	private List<Review> list;

    public ReviewList(List<Review> reviewList){
        this.list = reviewList;
    }

    public void add(Review review){
        list.add(review);
    }

}
