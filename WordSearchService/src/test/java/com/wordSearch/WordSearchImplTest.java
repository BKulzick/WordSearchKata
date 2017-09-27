package com.wordSearch;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wordSearch.model.WordFinderAnswer;
import com.wordSearch.model.WordPuzzle;
import com.wordSearch.utils.WordFinder;
import com.wordSearch.utils.WordPuzzleConverter;

public class WordSearchImplTest {

	private WordPuzzleConverter puzzleConverter;
	private WordPuzzle puzzle;
	private static final String RESOURCES_WORDSEARCH_TXT = "resources/wordsearch.txt";
	
	
	@Before
	public void setup() {
		puzzleConverter = new WordPuzzleConverter();
		puzzle = new WordPuzzle();
	}
	@Test
	public void whenAPuzzleToReadReturnAnArrayOfTheFirstWordLocation() {
		WordSearchImpl impl = new WordSearchImpl();
		List<WordFinderAnswer> answer = impl.solveThisPuzzle(RESOURCES_WORDSEARCH_TXT);
		Assert.assertTrue(answer.get(0).getIsWordFound());
		Assert.assertEquals((Integer)0, answer.get(0).getXLocation());
		Assert.assertEquals((Integer)6, answer.get(0).getYLocation());
		
	}
}
