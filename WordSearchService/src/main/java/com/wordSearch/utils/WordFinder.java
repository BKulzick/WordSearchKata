package com.wordSearch.utils;

public class WordFinder {

	public boolean searchFor(String word, String puzzleLine) {
		if (puzzleLine.contains(word)) { return true; }
		return false;
	}

}
