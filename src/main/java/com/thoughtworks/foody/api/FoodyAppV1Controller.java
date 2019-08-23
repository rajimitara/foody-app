package com.thoughtworks.foody.api;

import java.io.IOException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.foody.dto.RatingRequest;
import com.thoughtworks.foody.exception.NotFoundException;
import com.thoughtworks.foody.model.Restuarant;
import com.thoughtworks.foody.service.FoodyServices;

@RestController("/v1/foody")
public class FoodyAppV1Controller {

	@Autowired
	FoodyServices foodyService;
	
	@PostMapping(value="/restuarants/search/{resturantId}")
	public ResponseEntity<String> searchResturantsByName(@RequestParam String resturantId){
		try{
			return new ResponseEntity<String>(foodyService.searchByRestuarant(resturantId).toString(),HttpStatus.OK);
		}catch(NotFoundException ex){
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
	
	//TODO : based on location
	@GetMapping(value="/restuarants/{resturantName}/rating")
	public ResponseEntity<Integer> getRestaurantRating(@RequestParam String resturantName){
		try{
			return new ResponseEntity<Integer>(foodyService.getRestuarantRating(resturantName),HttpStatus.OK);
		}catch(NotFoundException ex){
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(value="/restuarants/{resturantName}/rating")
	public ResponseEntity<String> addCustomerRating(@RequestBody String body,String resturantName){
		try{
			RatingRequest ratingRequest = (RatingRequest)convertJsonStringToJavaObj(body, RatingRequest.class);
			
			if(ratingRequest.getRating() >=1 && ratingRequest.getRating()<=5)
				throw new NotFoundException("Rating should be between 1 to 5");
			
			foodyService.addCustomerRating(resturantName,ratingRequest);
		
		}catch(NotFoundException ex){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	

	public static Object convertJsonStringToJavaObj(String json,
			Class<?> requiredType) {

		ObjectMapper mapper = new ObjectMapper();
		Object obj = null;
		try {
			obj = mapper.readValue(json, requiredType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			mapper = null;
		}

		return obj;
	}

}
