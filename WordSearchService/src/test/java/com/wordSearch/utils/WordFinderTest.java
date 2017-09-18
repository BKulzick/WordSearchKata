package com.wordSearch.utils;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.wordSearch.model.WordFinderAnswer;

public class WordFinderTest {

	private static final String STRING_HAS_BOY_AT_5 = "addadboydcefs";
	private static final String NOT_FOUND = "abcyefg";
	private static final String STRING_HAS_BOY_AT_4 = "abcboyefg";
	private static final String BOY = "boy";

	@Test
	public void whenGivenLettersWithWordEnsureGivenWordFound() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchFor(BOY,STRING_HAS_BOY_AT_4);
		assertTrue(answer.getIsWordFound());
	}
	
	@Test
	public void whenGivenLettersWithNoWordEnsureGivenWordNotFound() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchFor(BOY,NOT_FOUND);
		assertFalse(answer.getIsWordFound());
	}
	
	@Test
	public void whenWordIsFoundEnsureXCoordinateInLineReturns() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchFor(BOY,STRING_HAS_BOY_AT_5);
		assertTrue(answer.getIsWordFound());
		Assert.assertEquals(answer.getXLocation(),(Integer)5);
	}
	
}
