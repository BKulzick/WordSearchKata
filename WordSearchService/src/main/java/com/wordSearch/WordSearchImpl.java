package com.wordSearch;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wordSearch.model.WordFinderAnswer;
import com.wordSearch.utils.WordFinder;
import com.wordSearch.utils.WordPuzzleConverter;
import com.wordsearch.api.api.SearchApi;
import com.wordsearch.api.model.WordSearchRequest;
import com.wordsearch.api.model.WordSearchResponse;

public class WordSearchImpl implements SearchApi{

	private WordPuzzleConverter puzzleConverter = new WordPuzzleConverter();

	public List<WordFinderAnswer> solveThisPuzzle(String wordSearchLocation) {
		WordFinder finder = new WordFinder();
		List<WordFinderAnswer> answer = finder.searchThisPuzzle(puzzleConverter.convertPuzzleFrom(wordSearchLocation));
		return answer;
	}

	@Override
	public ResponseEntity<WordSearchResponse> searchForAllWords(WordSearchRequest body) {
		WordFinder finder = new WordFinder();
		WordPuzzleConverter converter= new WordPuzzleConverter();
		List<WordFinderAnswer> answer = finder.searchThisPuzzle(converter.convertToPuzzle(body.getWords(), body.getPuzzle()));
		WordSearchResponse response=converter.convertToResponse(answer);
		return new ResponseEntity<WordSearchResponse>(response, HttpStatus.OK);
	}
	
	public void setPuzzleConverter(WordPuzzleConverter puzzleConverter) {
		this.puzzleConverter = puzzleConverter;
	}

	
	
}
