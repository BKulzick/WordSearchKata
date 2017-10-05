package com.wordSearch.model;

import java.awt.Point;
import java.util.ArrayList;

import com.wordSearch.enums.AnswerType;

public class WordFinderAnswer {

	private boolean isWordFound;
	private Integer xLocation;
	private Integer yLocation;
	private Integer initialLocation;
	private ArrayList<Point> wordLocation;
	private AnswerType answerType;
	private String word;
	
	public WordFinderAnswer(boolean thisWordFound, AnswerType answerType) {
		this.isWordFound=thisWordFound;
		this.answerType=answerType;
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


	public Integer getYLocation() {
		return yLocation;
	}


	public ArrayList<Point> getWordLocation() {
		return wordLocation;
	}


	public void setWordLocation(ArrayList<Point> wordLocation) {
		this.wordLocation = wordLocation;
	}


	public AnswerType getAnswerType() {
		return answerType;
	}


	public void setAnswerType(AnswerType rowType) {
		this.answerType = rowType;
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}
	
	public String toString() {
		return this.word +": "+ buildReturnPointsString(wordLocation);
	}


	private String buildReturnPointsString(ArrayList<Point> wordLocation2) {
		StringBuilder points = new StringBuilder();
		wordLocation2.stream().forEach(x -> points.append("(" +(int)x.getX()+ "," +(int)x.getY() +"),"));
		points.deleteCharAt(points.lastIndexOf(","));
		return points.toString();
	}


	public void setIsFound(boolean isFound) {
		this.isWordFound=isFound;
		
	}


}
