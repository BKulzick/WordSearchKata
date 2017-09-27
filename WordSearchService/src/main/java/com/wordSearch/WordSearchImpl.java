package com.wordSearch;

import java.util.List;

import com.wordSearch.model.WordFinderAnswer;
import com.wordSearch.model.WordPuzzle;
import com.wordSearch.utils.WordFinder;
import com.wordSearch.utils.WordPuzzleConverter;

public class WordSearchImpl {

	public List<WordFinderAnswer> solveThisPuzzle(String wordSearchLocation) {
		WordPuzzleConverter puzzleConverter = new WordPuzzleConverter();
		WordFinder finder = new WordFinder();
		List<WordFinderAnswer> answer = finder.searchThisPuzzle(puzzleConverter.convertPuzzleFrom(wordSearchLocation));
		return answer;
	}

	
	
}
