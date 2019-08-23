package com.thoughtworks.foody.model;

import java.util.List;
import java.util.Map;

import com.thoughtworks.foody.model.Cuisine.CuisineType;

public class Restuarant {

	String hotelName;
	Location userLocation;
	CuisineType cuisine;
	Menu menu;
	int rating;
	Map<String,Integer> customersRating;
	
	public Map<String, Integer> getCustomersRating() {
		return customersRating;
	}
	public void setCustomersRating(Map<String, Integer> customersRating) {
		this.customersRating = customersRating;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Location getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(Location userLocation) {
		this.userLocation = userLocation;
	}
	public CuisineType getCuisine() {
		return cuisine;
	}
	public void setCuisine(CuisineType cuisine) {
		this.cuisine = cuisine;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	
}
