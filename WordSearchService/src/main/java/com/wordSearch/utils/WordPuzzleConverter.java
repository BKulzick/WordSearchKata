package com.wordSearch.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.wordSearch.model.WordPuzzle;

public class WordPuzzleConverter {

	private static WordPuzzle wordPuzzle = new  WordPuzzle();

	public static WordPuzzle convertPuzzleFrom(String filepath) {
		try {
			Files.readAllLines(Paths.get(filepath)).forEach(x -> addLinesToPuzzle(x));
		} catch (IOException e) {
			e.printStackTrace();
		};
		return wordPuzzle;
	}

	private static WordPuzzle addLinesToPuzzle(String x) {
		wordPuzzle.addLineToPuzzle(x);
		return wordPuzzle;
	}

}
