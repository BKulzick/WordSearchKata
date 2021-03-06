package com.wordSearch.utils;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import com.wordSearch.model.WordFinderAnswer;
import com.wordSearch.model.WordPuzzle;
import com.wordsearch.api.model.WordFinderAnswerLocation;
import com.wordsearch.api.model.WordSearchResponse;

public class WordPuzzleConverter {

	private static final int START_AT_ROW_ONE = 1;
	private static final int START_AT_BEGINNING = 0;
	private static final String COMMA = ",";
	private static final int START_AT_END = 0;
	private WordPuzzle wordPuzzle = new WordPuzzle();
	private WordSearchFileReader reader = new  WordSearchFileReader(); 

	public WordPuzzle convertPuzzleFrom(String filepath) {
		createPuzzleFromList(getReader().classreadLinesFromThisFile(filepath));
		return wordPuzzle;
	}


	private void createPuzzleFromList(List<String> list) {
		addHorizontalLinesToWordPuzzleFromFile(list);
		addVerticalLinesToWordPuzzle(wordPuzzle.getHorizontalRows());
		addDescendingDiagonalLinesToWordPuzzle(wordPuzzle.getHorizontalRows(), START_AT_BEGINNING);
		addDescendingDiagonalLinesToWordPuzzle(wordPuzzle.getVerticalRows(),START_AT_ROW_ONE);
		addAscendingDiagonalLinesToWordPuzzle(wordPuzzle.getHorizontalRows(),START_AT_END);
		addSecondAscendingDiagonalLinesToWordPuzzle(wordPuzzle.getHorizontalRows());
	}


	private void addSecondAscendingDiagonalLinesToWordPuzzle(List<String> rows) {
		for (int row = 1; row < rows.size(); row++) {
			createSecondAscendingDiagonalLines(rows, row);
		}
	}


	private void createSecondAscendingDiagonalLines(List<String> rows, int spot) {
		StringBuilder diagRow = new StringBuilder();
		int row =rows.size()-1;
		for (int i = 0; i < rows.size(); i++) {
			diagRow.append(rows.get(row).substring(i+spot, i+1+spot));
			row--;
			if(i+spot+1==rows.size()) { break; }
		}
		wordPuzzle.addDiagonalAscendingDiagToPuzzle(diagRow.toString());
	}


	private void addAscendingDiagonalLinesToWordPuzzle(List<String> rows, int startingRow) {
		for (int row = rows.size()-1; row >= 0; row--) {
			createAscendingDiagonalLines(rows, row, startingRow);
		}
	}

	private void createAscendingDiagonalLines(List<String> rows, int currentRow, int startingRow) {
		StringBuilder diagRow = new StringBuilder();
		for (int i = startingRow; i < rows.size(); i++) {
			diagRow.append(rows.get(currentRow).substring(i, i+1));
			currentRow--;
			if(currentRow<0) { break; }
		}
		wordPuzzle.addDiagonalAscendingDiagToPuzzle(diagRow.toString());
	}
		
	private void addHorizontalLinesToWordPuzzleFromFile(List<String> rows) {
		rows.forEach(x -> addLinesToPuzzle(x));
	}


	private void addDescendingDiagonalLinesToWordPuzzle(List<String> rows, Integer startingRow) {
		for (int row = startingRow; row < rows.size(); row++) {
			createDescendingDiagonalRow(row, rows);
			}
	}

	private void createDescendingDiagonalRow(Integer startingRow,List<String> rows) {
		StringBuilder diagRow = new StringBuilder();
		for (int i = 0; i < rows.size(); i++) {
			diagRow.append(rows.get(startingRow).substring(i, i+1));
			startingRow++;
			if(startingRow>=rows.size()) { break; }
		}
		wordPuzzle.addDiagonalYLineToPuzzle(diagRow.toString());
	}

	private void addVerticalLinesToWordPuzzle(List<String> horizontalRows) {
		for (int i = 0; i < horizontalRows.size(); i++) {
			createAdditionalVerticalRow(horizontalRows, i);			
		}
	}

	private void createAdditionalVerticalRow(List<String> horizontalRows, Integer index) {
		StringBuilder verticalRow = new StringBuilder();
		for (String row : horizontalRows) {
			verticalRow.append(row.substring(index, index+1));
		}
		wordPuzzle.addVerticalLineToPuzzle(verticalRow.toString());
	}

	private void addLinesToPuzzle(String row) {
		if(wordPuzzle.getWordsToFind().isEmpty()) { 
			wordPuzzle.setWordsToFind(convertToList(row));
			return;
		}
		wordPuzzle.addHorizontalLineToPuzzle(row.replace(",", ""));
	}

	private List<String> convertToList(String row) {
		return Arrays.asList(row.split(COMMA));
	}


	public WordSearchFileReader getReader() {
		return reader;
	}


	public void setReader(WordSearchFileReader reader) {
		this.reader = reader;
	}


	public  WordPuzzle convertToPuzzle(List<String> words, List<String> puzzle) {
		wordPuzzle.setWordsToFind(words);
		createPuzzleFromList(puzzle);
		return wordPuzzle;
	}


	public WordSearchResponse convertToResponse(List<WordFinderAnswer> answer) {
		WordSearchResponse response = new WordSearchResponse();
		answer.forEach(x -> response.addAnswerItem(convertToAnswerItem(x)));
		return response;
	}


	private com.wordsearch.api.model.WordFinderAnswer convertToAnswerItem(WordFinderAnswer x) {
		com.wordsearch.api.model.WordFinderAnswer newAnswer = new com.wordsearch.api.model.WordFinderAnswer();
		x.getWordLocation().stream().forEach(point -> newAnswer.addLocationItem(convertPointToLocation(point)));
		newAnswer.setWord(x.getWord());
		return newAnswer;
	}


	private WordFinderAnswerLocation convertPointToLocation(Point y) {
		WordFinderAnswerLocation location = new WordFinderAnswerLocation();
		location.setX((int) y.getX());
		location.setY((int) y.getY());
		return location;
	}
}
