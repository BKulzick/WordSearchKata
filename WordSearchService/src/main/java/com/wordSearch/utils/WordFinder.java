package com.wordSearch.utils;

import com.wordSearch.model.WordFinderAnswer;

public class WordFinder {

	public WordFinderAnswer searchFor(String word, String puzzleLine) {
		if (puzzleLine.contains(word)) { 
			return buildAnswerLocation(word, puzzleLine); 
			}
		if (puzzleLine.contains(backwards(word))) {
			WordFinderAnswer answer = buildAnswerLocation(backwards(word), puzzleLine);
			return reverseLocationForBackwardsAnswer(answer,puzzleLine);
		}
		
		return new WordFinderAnswer(false);
	}

	private WordFinderAnswer reverseLocationForBackwardsAnswer(WordFinderAnswer answer,String puzzleLine) {
		Integer correctLocation = puzzleLine.length() - answer.getXLocation();
		answer.setXLocation(correctLocation);
		return answer;
	}

	private WordFinderAnswer buildAnswerLocation(String word, String puzzleLine) {
		WordFinderAnswer answer =new WordFinderAnswer(true);
		answer.setXLocation(findLocationOfWordInPuzzle(word,puzzleLine));
		return answer;
	}

	private String backwards(String word) {
		return new StringBuilder(word).reverse().toString();
	}

	private Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
		return puzzleLine.indexOf(word);
	}

}
