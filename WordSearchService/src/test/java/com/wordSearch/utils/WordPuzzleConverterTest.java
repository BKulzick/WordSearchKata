package com.wordSearch.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wordSearch.model.WordPuzzle;

public class WordPuzzleConverterTest {

	
	
	private static final List<String> FIRST_LINE = new ArrayList<String>();
	private WordPuzzleConverter puzzleConverter;

	@Before
	public void setup() {
		puzzleConverter = new WordPuzzleConverter();
		FIRST_LINE.add("BONES");
		FIRST_LINE.add("KHAN");
		FIRST_LINE.add("KIRK");
		FIRST_LINE.add("SCOTTY");
		FIRST_LINE.add("SPOCK");
		FIRST_LINE.add("SULU");
		FIRST_LINE.add("UHURA");
	}
	
	@Test
	public void whenALineOfTextIsReadEnsureOneHorizontalRowHasBeenAdded() {
		WordPuzzle puzzle = puzzleConverter.convertPuzzleFrom("target/Resources/wordsearch.txt");
		assertEquals(FIRST_LINE,puzzle.getWordsToFind());
		
	}	
}
