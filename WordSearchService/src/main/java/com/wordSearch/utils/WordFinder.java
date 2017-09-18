package com.wordSearch.utils;

import com.wordSearch.model.WordFinderAnswer;

public class WordFinder {

	public WordFinderAnswer searchFor(String word, String puzzleLine) {
		if (puzzleLine.contains(word)) { 
			WordFinderAnswer answer =new WordFinderAnswer(true);
			Integer location  = findLocationOfWordInPuzzle(word,puzzleLine);
			answer.setXLocation(location);
			return answer; 
			}
		return new WordFinderAnswer(false);
	}

	private Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
		return puzzleLine.indexOf(word.substring(0, 1));
	}

}
