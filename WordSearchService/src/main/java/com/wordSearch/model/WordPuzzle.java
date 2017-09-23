package com.wordSearch.model;

import java.util.ArrayList;
import java.util.List;

public class WordPuzzle {

	private List<String> horizontalRows = new ArrayList<String>();
	private List<String> wordsToFind = new ArrayList<String>();
	private List<String> verticalRows = new ArrayList<String>();
	private List<String> diagonalYRows = new ArrayList<String>();

	public List<String> getHorizontalRows() {
		return horizontalRows;
	}

	public void addHorizontalLineToPuzzle(String x) {
		horizontalRows.add(x);
	}

	public List<String> getWordsToFind() {
		return wordsToFind;
	}

	public void setWordsToFind(List<String> wordsToFind) {
		this.wordsToFind = wordsToFind;
	}

	public List<String> getVerticalRows() {
		return verticalRows;
	}
	
	public void addVerticalLineToPuzzle(String x) {
		verticalRows.add(x);
	}

	public List<String> getDiagonalYRows() {
		return diagonalYRows ;
	}

	public void addDiagonalYLineToPuzzle(String row) {
		diagonalYRows.add(row);
		
	}


}
