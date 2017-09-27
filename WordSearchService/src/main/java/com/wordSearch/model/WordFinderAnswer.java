package com.wordSearch.model;

public class WordFinderAnswer {

	private boolean isWordFound;
	private Integer xLocation;
	private Integer yLocation;
	private Integer initialLocation;
	private boolean isBackwards;
	
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


	public void setYLocation(Integer wordLocation) {
		this.yLocation= wordLocation;		
	}


	public Integer getInitialLocation() {
		return initialLocation;
	}


	public void setInitialLocation(Integer initialLocation) {
		this.initialLocation = initialLocation;
	}


	public boolean isBackwards() {
		return isBackwards;
	}


	public void setBackwards(boolean isBackwards) {
		this.isBackwards = isBackwards;
	}


	public Integer getYLocation() {
		return yLocation;
	}


}
