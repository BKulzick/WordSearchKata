package com.wordSearch.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.wordSearch.model.WordPuzzle;

public class WordPuzzleConverterTest {

	
	
	private static final String FIRST_LINE = "BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA";

	@Test
	public void whenALineOfTextIsReadEnsureOneHorizontalRowHasBeenAdded() {
		WordPuzzle puzzle = WordPuzzleConverter.convertPuzzleFrom("target/Resources/wordsearch.txt");
		assertEquals(FIRST_LINE,puzzle.getHorizontalRows().get(0));
		
	}	
}
