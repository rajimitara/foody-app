package com.thoughtworks.foody.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.thoughtworks.foody.dto.RatingRequest;
import com.thoughtworks.foody.model.Location;
import com.thoughtworks.foody.model.Restuarant;

@Component
public class RestuarantService {

	Set<Restuarant> availableResturant;

	public void addToAvailableResturant(Restuarant restuarant){
		if(availableResturant==null){
			availableResturant = new HashSet<Restuarant>();
		}
		this.availableResturant.add(restuarant);
	}
	
	public Restuarant searchByName(String resturantName){
		Set<Restuarant> allResturant = getAvailableResturant().stream().filter(hotelName -> hotelName.equals(resturantName)).collect(Collectors.toSet());
		return allResturant.iterator().next();
	}
	
	//TODO : map to maps api
	public Set<Restuarant> searchByLocation(Location location){
		return null;
	}
	
	public void addCustomerRating(String hotelName, RatingRequest rating){
		Restuarant userReviewRestuarant = searchByName(hotelName);
		
		Map<String,Integer> customerReviews = userReviewRestuarant.getCustomersRating();
		
		customerReviews.put(rating.getUserName(),rating.getRating());
		
		calculateCustomerRating(customerReviews);
		
		userReviewRestuarant.setRating((int) calculateCustomerRating(customerReviews));
	}

	private double calculateCustomerRating(Map<String, Integer> customerReviews) {
		
		Double userRating = customerReviews.values().parallelStream().
				mapToDouble(Integer::intValue).average().getAsDouble();
		
		return Math.round(userRating);
		
		
	}
	
	
	public Set<Restuarant> getAvailableResturant() {
		return availableResturant;
	}

	public void setAvailableResturant(Set<Restuarant> availableResturant) {
		this.availableResturant = availableResturant;
	}
}
