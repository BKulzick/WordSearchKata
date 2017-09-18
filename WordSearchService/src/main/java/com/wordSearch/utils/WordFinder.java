package com.wordSearch.utils;

import com.wordSearch.model.WordFinderAnswer;

public class WordFinder {

	public WordFinderAnswer searchFor(String word, String puzzleLine) {
		if (puzzleLine.contains(word)) { return new WordFinderAnswer(true); }
		return new WordFinderAnswer(false);
	}

}
