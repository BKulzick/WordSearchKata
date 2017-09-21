package com.wordSearch.model;

import java.util.ArrayList;
import java.util.List;

public class WordPuzzle {

	private List<String> horizontalRows = new ArrayList<String>();
	private List<String> wordsToFind = new ArrayList<String>();

	public List<String> getHorizontalRows() {
		return horizontalRows;
	}

	public void addLineToPuzzle(String x) {
		horizontalRows.add(x);
	}

	public List<String> getWordsToFind() {
		return wordsToFind;
	}

	public void setWordsToFind(List<String> wordsToFind) {
		this.wordsToFind = wordsToFind;
	}


}
