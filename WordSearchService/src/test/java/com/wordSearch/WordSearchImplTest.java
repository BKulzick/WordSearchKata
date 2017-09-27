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
	public void whenAPuzzleToReadReturnAnArrayOfTheFirstWordLocationVerticalFowards() {
		WordSearchImpl impl = new WordSearchImpl();
		List<WordFinderAnswer> answer = impl.solveThisPuzzle(RESOURCES_WORDSEARCH_TXT);
		Assert.assertTrue(answer.get(0).getIsWordFound());
		Assert.assertEquals(0D, answer.get(0).getWordLocation().get(0).getX(), .01);
		Assert.assertEquals(6.0D, answer.get(0).getWordLocation().get(0).getY(), .01);
		Assert.assertEquals(0.0D, answer.get(0).getWordLocation().get(1).getX(), .01);
		Assert.assertEquals(7.0D, answer.get(0).getWordLocation().get(1).getY(), .01);
		Assert.assertEquals(0.0D, answer.get(0).getWordLocation().get(4).getX(), .01);
		Assert.assertEquals(10.0D, answer.get(0).getWordLocation().get(4).getY(), .01);
	}
}
