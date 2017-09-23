package com.wordSearch.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wordSearch.model.WordPuzzle;

public class WordPuzzleConverterTest {

	
	
	private static final int CORRECT_SIZE = 15;
	private static List<String> FIRST_LINE;;
	private static final String SECOND_LINE = "UMKHULKINVJOCWE";
	private WordPuzzleConverter puzzleConverter;
	private static final String VERTICAL_LINE = "ULHBASBONESTOWK";
	private static final String SECOND_V_LINE = "MLSRYCLKUYJGJZY";
	private static final String FOURTEEN_LINE = "KYLBQQPMDFCKEAB";
	private static final String DIAG_LINE_YAXIS1 = "ULUSGYEMECEOZXB";
	private static final String DIAG_LINE_YAXIS2 = "LSJATNMMPBTBUA";
	private static final String DIAG_LINE_YAXIS15 = "MSPOCKERMQMYUS";
	private static final Object CORRECT_DIAGONAL_SIZE = 29;
	

	@Before
	public void setup() {
		FIRST_LINE = new ArrayList<String>();
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
	public void whenALineOfTextIsReadEnsureWordsToFindHasBeenAdded() {
		WordPuzzle puzzle = puzzleConverter.convertPuzzleFrom("target/Resources/wordsearch.txt");
		assertEquals(FIRST_LINE,puzzle.getWordsToFind());
	}
	
	@Test
	public void whenSecondLineOfTextIsReadEnsureTheCorrectHorizontalRowHasBeenAdded() {
		WordPuzzle puzzle = puzzleConverter.convertPuzzleFrom("target/Resources/wordsearch.txt");
		assertEquals(SECOND_LINE,puzzle.getHorizontalRows().get(0));
		assertEquals(FOURTEEN_LINE,puzzle.getHorizontalRows().get(14));
		assertEquals(CORRECT_SIZE,puzzle.getHorizontalRows().size());
	}	
	@Test
	public void whenAllLinesOfTextAreReadEnsureTheCorrectVerticalRowHasBeenAdded() {
		WordPuzzle puzzle = puzzleConverter.convertPuzzleFrom("target/Resources/wordsearch.txt");
		assertEquals(VERTICAL_LINE,puzzle.getVerticalRows().get(0));
		assertEquals(SECOND_V_LINE,puzzle.getVerticalRows().get(1));
		assertEquals(CORRECT_SIZE,puzzle.getVerticalRows().size());
	}	
	
	@Test
	public void whenAllLinesOfTextAreReadEnsureTheCorrectDiagonalRowHasBeenAdded() {
		WordPuzzle puzzle = puzzleConverter.convertPuzzleFrom("target/Resources/wordsearch.txt");
		assertEquals(DIAG_LINE_YAXIS1,puzzle.getDiagonalYRows().get(0));
		assertEquals(DIAG_LINE_YAXIS2,puzzle.getDiagonalYRows().get(1));
		assertEquals(DIAG_LINE_YAXIS15,puzzle.getDiagonalYRows().get(15));
		assertEquals(CORRECT_DIAGONAL_SIZE,puzzle.getDiagonalYRows().size());
		
	}
	
	
	
}
