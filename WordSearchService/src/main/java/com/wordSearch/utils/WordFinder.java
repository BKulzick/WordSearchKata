package com.wordSearch.utils;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.wordSearch.enums.AnswerType;
import com.wordSearch.model.WordFinderAnswer;
import com.wordSearch.model.WordPuzzle;

public class WordFinder {

	public WordFinderAnswer searchForForwards(String word, String puzzleLine, AnswerType answerType) {
		if (puzzleLine.contains(word)) { 
			return buildAnswerLocation(word, puzzleLine, answerType); 
			}
		return new WordFinderAnswer(false, answerType);
	}

	public WordFinderAnswer searchForBackwards(String word, String puzzleLine, AnswerType answerType) {
		if (puzzleLine.contains(backwards(word))) {
			return buildAnswerLocation(backwards(word), puzzleLine, answerType);
		}
		return new WordFinderAnswer(false, answerType);
	}

	private WordFinderAnswer buildAnswerLocation(String word, String puzzleLine, AnswerType answerType) {
		WordFinderAnswer answer =new WordFinderAnswer(true, answerType);
		answer.setInitialLocation(answerType.findLocationOfWordInPuzzle(word,puzzleLine));
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
		List<WordFinderAnswer> answers = new ArrayList<>();
		for (String word : wordsToFind) {
			answers.add(searchForThisWord(word, puzzle));
		}
		return answers;
	}

	private WordFinderAnswer searchForThisWord(String word, WordPuzzle puzzle) {
		WordFinderAnswer answer = new WordFinderAnswer(false, null);
		answer = searchRows(word, puzzle, answer, AnswerType.VERTICAL_FORWARD);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchBackwardsRows(word, puzzle, answer, AnswerType.VERTICAL_BACKWARD);
		if(answer.getIsWordFound()) { return answer; }
			answer = searchBackwardsRows(word, puzzle, answer, AnswerType.HORIZONTAL_BACKWARD);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchRows(word, puzzle, answer, AnswerType.HORIZONTAL_FORWARD);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchRows(word, puzzle, answer, AnswerType.DIAGONAL_DESCENDING);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchBackwardsRows(word, puzzle, answer, AnswerType.DIAGONAL_DESCENDING_BACKWARD);
		
		return answer;
	}

	private WordFinderAnswer searchRows(String word, WordPuzzle puzzle, WordFinderAnswer answer, AnswerType answerType) {
		for (int row = 0; row<answerType.getRow(puzzle).size(); row++) {
			answer = searchForForwards(word,answerType.getRow(puzzle).get(row), answerType);
			if (answer.getIsWordFound()) { 
				return createAnswerFromLocation(word, answer, row, answerType, answerType.getRow(puzzle).get(row).length()); 
				}
		}
		return answer;
	}
	
	private WordFinderAnswer searchBackwardsRows(String word, WordPuzzle puzzle, WordFinderAnswer answer, AnswerType answerType) {
		for (int row = 0; row<answerType.getRow(puzzle).size(); row++) {
			answer = searchForBackwards(word,answerType.getRow(puzzle).get(row), answerType);
			if (answer.getIsWordFound()) { 
				return createAnswerFromLocation(word, answer, row, answerType,answerType.getRow(puzzle).get(row).length() ); 
				}
		}
		return answer;
	}

	private WordFinderAnswer createAnswerFromLocation(String word, WordFinderAnswer answer, int row, AnswerType m, int lengthOfPuzzle) {
			answer.setWordLocation(m.buildLocations(word, row, answer.getInitialLocation(), lengthOfPuzzle));
		return answer;
	}

}
