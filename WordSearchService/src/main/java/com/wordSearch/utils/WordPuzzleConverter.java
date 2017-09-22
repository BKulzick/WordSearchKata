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
		return wordPuzzle;
	}

	private void addVerticalLinesToWordPuzzle() {
		List<String> horizontalRows = wordPuzzle.getHorizontalRows();
		StringBuilder verticalRow = new StringBuilder();
		for (String row : horizontalRows) {
			verticalRow.append(row.substring(0, 1));
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
