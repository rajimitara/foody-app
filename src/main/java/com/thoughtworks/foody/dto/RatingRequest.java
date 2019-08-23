package com.thoughtworks.foody.dto;

public class RatingRequest {
	
	String userName;
	int rating;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
			this.rating = rating;
	}

}
