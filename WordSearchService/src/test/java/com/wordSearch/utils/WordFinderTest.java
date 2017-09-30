package com.wordSearch.utils;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.wordSearch.enums.AnswerType;
import com.wordSearch.model.WordFinderAnswer;

public class WordFinderTest {

	private static final Integer FOURTH_SPOT = 4;
	private static final Integer FIFTH_SPOT = 5;
	private static final String STRING_HAS_BOY_AT_5 = "addadboydcefs";
	private static final String NOT_FOUND = "abcyefg";
	private static final String STRING_HAS_BOY_AT_4 = "gadcboyefg";
	private static final String DUPLICATE_BOY_AT_4 = "gbdcboyefg";
	private static final String BOY = "boy";
	private static final String BACKWARDS_BOY_AT_5 = "012yob00";

	@Test
	public void whenGivenLettersWithWordEnsureGivenWordFound() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchForForwards(BOY,STRING_HAS_BOY_AT_4, AnswerType.HORIZONTAL_FORWARD);
		assertTrue(answer.getIsWordFound());
		assertEquals(FOURTH_SPOT,answer.getInitialLocation());
	}
	
	@Test
	public void whenGivenLettersWithNoWordEnsureGivenWordNotFound() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchForForwards(BOY,NOT_FOUND, AnswerType.HORIZONTAL_FORWARD);
		assertFalse(answer.getIsWordFound());
	}
	
	@Test
	public void whenWordIsFoundEnsureXCoordinateInLineReturns() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchForForwards(BOY,STRING_HAS_BOY_AT_5, AnswerType.HORIZONTAL_FORWARD);
		assertTrue(answer.getIsWordFound());
		Assert.assertEquals(FIFTH_SPOT, answer.getInitialLocation());
	}
	
	@Test
	public void whenWordIsFoundEnsureXCoordinateInLineReturnsAtSpotFour() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchForForwards(BOY,STRING_HAS_BOY_AT_4, AnswerType.HORIZONTAL_FORWARD);
		assertTrue(answer.getIsWordFound());
		Assert.assertEquals(FOURTH_SPOT,answer.getInitialLocation());
	}	
	
	@Test
	public void whenWordIsFoundEnsureXCoordinateInLineReturnsAtSpotFourWhenDuplicateLettersExist() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchForForwards(BOY,DUPLICATE_BOY_AT_4, AnswerType.HORIZONTAL_FORWARD);
		assertTrue(answer.getIsWordFound());
		Assert.assertEquals(FOURTH_SPOT,answer.getInitialLocation());
	}	
	
	@Test
	public void whenWordExistsBackwordsEnsureXCoordinateInLineReturnsAtSpotFive() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchForBackwards(BOY,BACKWARDS_BOY_AT_5, AnswerType.HORIZONTAL_BACKWARD);
		assertTrue(answer.getIsWordFound());
		Assert.assertEquals(FIFTH_SPOT,answer.getInitialLocation());
	}
	
	
}
