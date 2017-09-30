package com.wordSearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	public void whenAPuzzleIsReadReturnAnArrayOfTheFirstWordLocationVerticalFowards() {
		WordSearchImpl impl = new WordSearchImpl();
		List<WordFinderAnswer> answer = impl.solveThisPuzzle(RESOURCES_WORDSEARCH_TXT);
		assertTrue(answer.get(0).getIsWordFound());
		assertEquals(0, answer.get(0).getWordLocation().get(0).getX(), .01);
		assertEquals(6, answer.get(0).getWordLocation().get(0).getY(), .01);
		assertEquals(0, answer.get(0).getWordLocation().get(1).getX(), .01);
		assertEquals(7, answer.get(0).getWordLocation().get(1).getY(), .01);
		assertEquals(0, answer.get(0).getWordLocation().get(4).getX(), .01);
		assertEquals(10, answer.get(0).getWordLocation().get(4).getY(), .01);
	}
	
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheSecondWordLocationVerticalBackwards() {
		WordSearchImpl impl = new WordSearchImpl();
		List<WordFinderAnswer> answer = impl.solveThisPuzzle(RESOURCES_WORDSEARCH_TXT);
		assertTrue(answer.get(1).getIsWordFound());
		assertEquals(5, answer.get(1).getWordLocation().get(0).getX(), .01);
		assertEquals(9, answer.get(1).getWordLocation().get(0).getY(), .01);
		assertEquals(5, answer.get(1).getWordLocation().get(1).getX(), .01);
		assertEquals(8, answer.get(1).getWordLocation().get(1).getY(), .01);
		assertEquals(5, answer.get(1).getWordLocation().get(3).getX(), .01);
		assertEquals(6, answer.get(1).getWordLocation().get(3).getY(), .01);
	}
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheFirstThirdLocationHorizontalBackwords() {
		WordSearchImpl impl = new WordSearchImpl();
		List<WordFinderAnswer> answer = impl.solveThisPuzzle(RESOURCES_WORDSEARCH_TXT);
		assertTrue(answer.get(2).getIsWordFound());
		assertEquals(4, answer.get(2).getWordLocation().get(0).getX(), .01);
		assertEquals(7, answer.get(2).getWordLocation().get(0).getY(), .01);
		assertEquals(3, answer.get(2).getWordLocation().get(1).getX(), .01);
		assertEquals(7, answer.get(2).getWordLocation().get(1).getY(), .01);
		assertEquals(1, answer.get(2).getWordLocation().get(3).getX(), .01);
		assertEquals(7, answer.get(2).getWordLocation().get(3).getY(), .01);
	}
	
}
