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
		return wordPuzzle;
	}

	private void addLinesToPuzzle(String row) {
		if(wordPuzzle.getWordsToFind().isEmpty()) { 
			wordPuzzle.setWordsToFind(convertToList(row));
		}
		wordPuzzle.addLineToPuzzle(row);
	}

	private List<String> convertToList(String row) {
		return Arrays.asList(row.split(COMMA));
	}
}
