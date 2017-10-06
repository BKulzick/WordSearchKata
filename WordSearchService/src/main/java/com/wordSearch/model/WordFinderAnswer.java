package com.wordSearch.model;

import java.awt.Point;
import java.util.ArrayList;

import com.wordSearch.enums.AnswerType;

public class WordFinderAnswer {

	private boolean isWordFound;
	private Integer initialLocation;
	private ArrayList<Point> wordLocation;
	private AnswerType answerType;
	private String word;
	
	public WordFinderAnswer(boolean thisWordFound, AnswerType answerType) {
		this.isWordFound=thisWordFound;
		this.answerType=answerType;
	}
	
	public WordFinderAnswer(boolean thisWordFound) {
		this.isWordFound=thisWordFound;
	}


	public boolean getIsWordFound() {
		return isWordFound;
	}

	public Integer getInitialLocation() {
		return initialLocation;
	}


	public void setInitialLocation(Integer initialLocation) {
		this.initialLocation = initialLocation;
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
