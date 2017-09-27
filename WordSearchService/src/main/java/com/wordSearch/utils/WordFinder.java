package com.wordSearch.utils;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.wordSearch.model.WordFinderAnswer;
import com.wordSearch.model.WordPuzzle;

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
		answer.setInitialLocation(correctLocation);
		answer.setBackwards(true);
		return answer;
	}

	private WordFinderAnswer buildAnswerLocation(String word, String puzzleLine) {
		WordFinderAnswer answer =new WordFinderAnswer(true);
		answer.setInitialLocation(findLocationOfWordInPuzzle(word,puzzleLine));
		answer.setBackwards(false);
		return answer;
	}

	private String backwards(String word) {
		return new StringBuilder(word).reverse().toString();
	}

	private Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
		return puzzleLine.indexOf(word);
	}

	public List<WordFinderAnswer> searchThisPuzzle(WordPuzzle puzzle) {
		List<String> wordsToFind = puzzle.getWordsToFind();
		WordFinderAnswer answer = searchForThisWord(wordsToFind.get(0), puzzle);
		List<WordFinderAnswer> answers = new ArrayList<>();
		answers.add(answer);
		return answers;
	}

	private WordFinderAnswer searchForThisWord(String word, WordPuzzle puzzle) {
		List<String> verticalRows = puzzle.getVerticalRows();
		WordFinderAnswer answer = new WordFinderAnswer(false);
		answer = searchVerticalRows(word, verticalRows, answer);
		return answer;
	}

	private WordFinderAnswer searchVerticalRows(String word, List<String> verticalRows, WordFinderAnswer answer) {
		for (int row = 0; row<=verticalRows.size(); row++) {
			answer = searchFor(word,verticalRows.get(row));
			if (answer.getIsWordFound()) { 
				if(!answer.isBackwards()) {
					answer.setWordLocation(buildYForwardLocations(word,row,answer.getInitialLocation()));
				}
				if(answer.isBackwards()) {
					answer.setWordLocation(buildYBackwardsLocations(word,row,answer.getInitialLocation()));
				}
				
				return answer; }
		}
		return answer;
	}

	private ArrayList<Point> buildYBackwardsLocations(String word, int row, Integer initialLocation) {
		ArrayList<Point> wordLocation = new ArrayList<>();
		for(int i =0; i<word.length(); i++) {
			wordLocation.add(new Point(row, initialLocation-i));
		}
		return wordLocation;
	}

	private ArrayList<Point> buildYForwardLocations(String word, int row, Integer initialLocation) {
		ArrayList<Point> wordLocation = new ArrayList<>();
		for(int i =0; i<word.length(); i++) {
			wordLocation.add(new Point(row, initialLocation+i));
		}
		return wordLocation;
	}

}
