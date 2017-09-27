package com.wordSearch.utils;

import static com.wordSearch.utils.WordSearchFileReader.classreadLinesFromThisFile;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class WordSearchFileReaderTest {

	private static final String SECOND_LINE = "U,M,K,H,U,L,K,I,N,V,J,O,C,W,E";

	@Test
	public void whenFileReaderGivenTxtFileEnsureListReturned() {
		List<String> wordSearch = classreadLinesFromThisFile("resources/wordsearch.txt");
		assertEquals(SECOND_LINE,wordSearch.get(1));
	}

}
