package com.wordSearch.utils;

import static com.wordSearch.utils.WordSearchFileReader.classreadLinesFromThisFile;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wordSearch.model.WordPuzzle;

public class WordPuzzleConverter {

	private static final int START_AT_ROW_ONE = 1;
	private static final int START_AT_BEGINNING = 0;
	private static final String COMMA = ",";
	private static final int START_AT_END = 0;
	private WordPuzzle wordPuzzle; 

	public WordPuzzle convertPuzzleFrom(String filepath) {
		wordPuzzle = new WordPuzzle();
		addHorizontalLinesToWordPuzzleFromFile(classreadLinesFromThisFile(filepath));
		addVerticalLinesToWordPuzzle(wordPuzzle.getHorizontalRows());
		addDescendingDiagonalLinesToWordPuzzle(wordPuzzle.getHorizontalRows(), START_AT_BEGINNING);
		addDescendingDiagonalLinesToWordPuzzle(wordPuzzle.getVerticalRows(),START_AT_ROW_ONE);
		addAscendingDiagonalLinesToWordPuzzle(wordPuzzle.getHorizontalRows(),START_AT_END);
		addSecondAscendingDiagonalLinesToWordPuzzle(wordPuzzle.getHorizontalRows());
		return wordPuzzle;
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
}
