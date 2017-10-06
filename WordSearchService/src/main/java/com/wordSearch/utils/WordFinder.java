package com.wordSearch.utils;

import static com.wordSearch.enums.AnswerType.DIAGONAL_ASCENDING_BACKWARD;
import static com.wordSearch.enums.AnswerType.DIAGONAL_DESCENDING;
import static com.wordSearch.enums.AnswerType.DIAGONAL_DESCENDING_BACKWARD;
import static com.wordSearch.enums.AnswerType.HORIZONTAL_BACKWARD;
import static com.wordSearch.enums.AnswerType.HORIZONTAL_FORWARD;
import static com.wordSearch.enums.AnswerType.VERTICAL_BACKWARD;
import static com.wordSearch.enums.AnswerType.VERTICAL_FORWARD;

import java.util.ArrayList;
import java.util.List;

import com.wordSearch.enums.AnswerType;
import com.wordSearch.model.WordFinderAnswer;
import com.wordSearch.model.WordPuzzle;

public class WordFinder {

	public WordFinderAnswer searchFor(String word, String puzzleLine, AnswerType answerType) {
		if (puzzleLine.contains(word)) { 
			return buildAnswerLocation(word, puzzleLine, answerType); 
			}
		return new WordFinderAnswer(false, answerType);
	}

	private WordFinderAnswer buildAnswerLocation(String word, String puzzleLine, AnswerType answerType) {
		WordFinderAnswer answer =new WordFinderAnswer(true, answerType);
		answer.setInitialLocation(answerType.findLocationOfWordInPuzzle(word,puzzleLine));
		answer.setWord(answerType.getWord(word));
		return answer;
	}

	private String backwards(String word) {
		return new StringBuilder(word).reverse().toString();
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
		WordFinderAnswer answer = new WordFinderAnswer(false);
		answer = searchRows(word, puzzle, answer, VERTICAL_FORWARD);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchRows(backwards(word), puzzle, answer, VERTICAL_BACKWARD);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchRows(backwards(word), puzzle, answer, HORIZONTAL_BACKWARD);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchRows(word, puzzle, answer, HORIZONTAL_FORWARD);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchRows(word, puzzle, answer, DIAGONAL_DESCENDING);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchRows(backwards(word), puzzle, answer, DIAGONAL_DESCENDING_BACKWARD);
		if(answer.getIsWordFound()) { return answer; }
		answer = searchRows(backwards(word), puzzle, answer, DIAGONAL_ASCENDING_BACKWARD);
		
		return answer;
	}

	private WordFinderAnswer searchRows(String word, WordPuzzle puzzle, WordFinderAnswer answer, AnswerType answerType) {
		for (int row = 0; row<answerType.getRow(puzzle).size(); row++) {
			answer = searchFor(word,answerType.getRow(puzzle).get(row), answerType);
			if (answer.getIsWordFound()) { 
				return createAnswerFromLocation(word, answer, row, answerType, puzzle.getHorizontalRows().get(0).length()); 
				}
		}
		return answer;
	}

	private WordFinderAnswer createAnswerFromLocation(String word, WordFinderAnswer answer, int row, AnswerType m, int lengthOfPuzzle) {
			answer.setWordLocation(m.buildLocations(word, row, answer.getInitialLocation(), lengthOfPuzzle));
		return answer;
	}

}
