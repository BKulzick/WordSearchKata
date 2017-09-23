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
	private WordPuzzle wordPuzzle; 

	public WordPuzzle convertPuzzleFrom(String filepath) {
		wordPuzzle = new WordPuzzle();
		addHorizontalLinesToWordPuzzleFromFile(classreadLinesFromThisFile(filepath));
		addVerticalLinesToWordPuzzle(wordPuzzle.getHorizontalRows());
		addDiagonalLinesToWordPuzzle(wordPuzzle.getHorizontalRows(), START_AT_BEGINNING);
		addDiagonalLinesToWordPuzzle(wordPuzzle.getVerticalRows(),START_AT_ROW_ONE);
		return wordPuzzle;
	}

	private void addHorizontalLinesToWordPuzzleFromFile(List<String> rows) {
		rows.forEach(x -> addLinesToPuzzle(x));
	}


	private void addDiagonalLinesToWordPuzzle(List<String> rows, Integer startingRow) {
		for (int row = startingRow; row < rows.size(); row++) {
			addAdditionalDiagonalRow(row, rows);
			}
	}

	private void addAdditionalDiagonalRow(Integer startingRow,List<String> rows) {
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
