package com.wordSearch.utils;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class WordFinderTest {

	@Test
	public void whenGivenLettersWithWordEnsureGivenWordFound() {
		WordFinder finder = new WordFinder();
		Assert.assertTrue(finder.searchFor("boy","abcboyefg"));
	}
	
	@Test
	public void whenGivenLettersWithNoWordEnsureGivenWordNotFound() {
		WordFinder finder = new WordFinder();
		Assert.assertFalse(finder.searchFor("boy","abcyefg"));
	}

}
