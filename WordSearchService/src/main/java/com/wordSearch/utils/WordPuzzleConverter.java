package com.wordSearch.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.wordSearch.model.WordPuzzle;

public class WordPuzzleConverter {

	private static final String COMMA = ",";
	private WordPuzzle wordPuzzle = new  WordPuzzle();

	public WordPuzzle convertPuzzleFrom(String filepath) {
		
		try {
			Files.readAllLines(Paths.get(filepath)).forEach(x -> addLinesToPuzzle(x));
		} catch (IOException e) {
			e.printStackTrace();
		};
		addVerticalLinesToWordPuzzle();
		addDiagonalYLinesToWordPuzzle();
		return wordPuzzle;
	}

	private void addDiagonalYLinesToWordPuzzle() {
		List<String> horizontalRows = wordPuzzle.getHorizontalRows();
		for (int row = 0; row < horizontalRows.size(); row++) {
			createAdditionalDiagonalRow(row);
			}
	}

	private void createAdditionalDiagonalRow(Integer startingRow) {
		StringBuilder diagRow = new StringBuilder();
		for (int i = 0; i < wordPuzzle.getHorizontalRows().size(); i++) {
			diagRow.append(wordPuzzle.getHorizontalRows().get(startingRow).substring(i, i+1));
			startingRow++;
			if(startingRow>=wordPuzzle.getHorizontalRows().size()) { break; }
		}
		wordPuzzle.addDiagonalYLineToPuzzle(diagRow.toString());
	}

	private void addVerticalLinesToWordPuzzle() {
		List<String> horizontalRows = wordPuzzle.getHorizontalRows();
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
