package com.wordSearch;

import java.util.List;

import com.wordSearch.model.WordFinderAnswer;
import com.wordSearch.utils.WordFinder;
import com.wordSearch.utils.WordPuzzleConverter;

public class WordSearchImpl {

	private WordPuzzleConverter puzzleConverter = new WordPuzzleConverter();

	public List<WordFinderAnswer> solveThisPuzzle(String wordSearchLocation) {
		WordFinder finder = new WordFinder();
		List<WordFinderAnswer> answer = finder.searchThisPuzzle(puzzleConverter.convertPuzzleFrom(wordSearchLocation));
		return answer;
	}

	public void setPuzzleConverter(WordPuzzleConverter puzzleConverter) {
		this.puzzleConverter = puzzleConverter;
	}

	
	
}
