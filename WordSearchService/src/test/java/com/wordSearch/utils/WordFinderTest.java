package com.wordSearch.utils;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class WordFinderTest {

	@Test
	public void whenGivenLettersEnsureGivenWordFound() {
		WordFinder finder = new WordFinder();
		Assert.assertTrue(finder.searchFor("boy","abcboyefg"));
	}

}
