package com.thoughtworks.foody.model;

import java.util.List;

public class Menu extends Item{
	
	List<MenuItem> listOfItems;

	public List<MenuItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<MenuItem> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	
}
