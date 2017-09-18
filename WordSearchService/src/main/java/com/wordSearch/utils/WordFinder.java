package com.wordSearch.utils;

import com.wordSearch.model.WordFinderAnswer;

public class WordFinder {

	public WordFinderAnswer searchFor(String word, String puzzleLine) {
		if (puzzleLine.contains(word)) { 
			WordFinderAnswer answer =new WordFinderAnswer(true);
			answer.setXLocation(5);
			return answer; 
			}
		return new WordFinderAnswer(false);
	}

}
