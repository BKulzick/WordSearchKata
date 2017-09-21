package com.wordSearch.model;

public class WordFinderAnswer {

	private boolean isWordFound;
	private Integer xLocation;

	public WordFinderAnswer(boolean thisWordFound) {
		this.isWordFound=thisWordFound;
	}


	public boolean getIsWordFound() {
		return isWordFound;
	}


	public Integer getXLocation() {
		return xLocation;
	}


	public void setXLocation(Integer wordLocation) {
		this.xLocation= wordLocation;		
	}

}
