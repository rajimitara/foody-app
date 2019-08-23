package com.thoughtworks.foody.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thoughtworks.foody.dto.RatingRequest;
import com.thoughtworks.foody.exception.NotFoundException;
import com.thoughtworks.foody.model.Restuarant;
import com.thoughtworks.foody.repository.RestuarantService;
import com.thoughtworks.foody.service.FoodyServices;

@Component
public class FoodyServiceImpl implements FoodyServices{
	
	@Autowired
	RestuarantService restuarantService;
	
	@Override
	public Restuarant searchByRestuarant(String hotelName) throws NotFoundException {
		
		//first level search by Name and filter with location or viceversa
		return restuarantService.searchByName(hotelName);
	}

	@Override
	public void addCustomerRating(String hotelName, RatingRequest rating) throws NotFoundException {
		
		restuarantService.addCustomerRating(hotelName, rating);
		
	}

	@Override
	public int getRestuarantRating(String resturantName) throws NotFoundException {
		
		return searchByRestuarant(resturantName).getRating();
	}

	

}
