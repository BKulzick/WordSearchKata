package com.wordSearch.utils;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.wordSearch.model.WordFinderAnswer;

public class WordFinderTest {

	@Test
	public void whenGivenLettersWithWordEnsureGivenWordFound() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchFor("boy","abcboyefg");
		assertTrue(answer.getIsWordFound());
	}
	
	@Test
	public void whenGivenLettersWithNoWordEnsureGivenWordNotFound() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchFor("boy","abcyefg");
		assertFalse(answer.getIsWordFound());
	}
	
	@Test
	public void whenWordIsFoundEnsureXCoordinateInLineReturns() {
		WordFinder finder = new WordFinder();
		WordFinderAnswer answer = finder.searchFor("boy","addadboydcefs");
		assertTrue(answer.getIsWordFound());
		Assert.assertEquals(answer.getXLocation(),(Integer)5);
	}
	
}
