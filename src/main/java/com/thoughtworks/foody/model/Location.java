package com.thoughtworks.foody.model;


//Basically Address but map to location for calculation
public class Location {

	//TODO : decide datatype
	String locateMe; 
	
	String userAddress;
	
	
	public String getLocateMe() {
		return locateMe;
	}

	public void setLocateMe(String locateMe) {
		this.locateMe = locateMe;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	
}
