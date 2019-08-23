package com.thoughtworks.foody.service;


import com.thoughtworks.foody.dto.RatingRequest;
import com.thoughtworks.foody.exception.NotFoundException;
import com.thoughtworks.foody.model.Restuarant;

public interface FoodyServices {

	public Restuarant searchByRestuarant(String hotelName)throws NotFoundException;
	
	public void addCustomerRating(String hotelName, RatingRequest ratingRequest)throws NotFoundException;
	
	public int getRestuarantRating(String resturantName)throws NotFoundException;
}
