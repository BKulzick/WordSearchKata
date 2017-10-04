package com.wordSearch.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordSearchFileReader {

	public List<String> classreadLinesFromThisFile(String filepath) {
		List<String> fileStream = new ArrayList<>();
		try {
			fileStream = Files.readAllLines(Paths.get(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		return fileStream;
	}

}
