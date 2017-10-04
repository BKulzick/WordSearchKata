package com.wordSearch.utils;

import static com.wordSearch.utils.MockWordPuzzleCreator.buildMockWordPuzzle;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

import com.wordSearch.model.WordPuzzle;

public class WordPuzzleConverterTest {

	
	
	private static final String RESOURCES_WORDSEARCH_TXT = "resources/wordsearch.txt";
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
	private static final int CORRECT_DIAGONAL_SIZE = 58;
	private static final String DIAG_LINE_0 = "KZYBMKQMEEHKXYE";
	private static final String DIAG_LINE_1 = "WJLZGHMERQKBUW";
	private static final String DIAG_LINE_16 = "LIUCIJEMUPTLG";
	private WordPuzzle puzzle;
	

	@Before
	public void setup() {
		puzzleConverter = new WordPuzzleConverter();
		FIRST_LINE = buildFirstLine();
		WordSearchFileReader mockReader = mock(WordSearchFileReader.class);
		Mockito.when(mockReader.classreadLinesFromThisFile(Mockito.anyString())).thenReturn(buildMockWordPuzzle());
		puzzleConverter.setReader(mockReader);
		puzzle = puzzleConverter.convertPuzzleFrom(RESOURCES_WORDSEARCH_TXT);

	}

	private List<String> buildFirstLine() {
		List<String> firstLine = new ArrayList<String>();
		firstLine.add("BONES");
		firstLine.add("KHAN");
		firstLine.add("KIRK");
		firstLine.add("SCOTTY");
		firstLine.add("SPOCK");
		firstLine.add("SULU");
		firstLine.add("UHURA");
		return firstLine;
	}

	@Test
	public void whenALineOfTextIsReadEnsureWordsToFindHasBeenAdded() {
		assertEquals(FIRST_LINE,puzzle.getWordsToFind());
	}
	
	@Test
	public void whenSecondLineOfTextIsReadEnsureTheCorrectHorizontalRowHasBeenAdded() {
		assertEquals(SECOND_LINE,puzzle.getHorizontalRows().get(0));
		assertEquals(FOURTEEN_LINE,puzzle.getHorizontalRows().get(14));
		assertEquals(CORRECT_SIZE,puzzle.getHorizontalRows().size());
	}	
	@Test
	public void whenAllLinesOfTextAreReadEnsureTheCorrectVerticalRowHasBeenAdded() {
		assertEquals(VERTICAL_LINE,puzzle.getVerticalRows().get(0));
		assertEquals(SECOND_V_LINE,puzzle.getVerticalRows().get(1));
		assertEquals(CORRECT_SIZE,puzzle.getVerticalRows().size());
	}	
	
	@Test
	public void whenAllLinesOfTextAreReadEnsureTheCorrectDescendingDiagonalRowHasBeenAdded() {
		assertEquals(DIAG_LINE_YAXIS1,puzzle.getDescendingDiagonalRows().get(0));
		assertEquals(DIAG_LINE_YAXIS2,puzzle.getDescendingDiagonalRows().get(1));
		assertEquals(DIAG_LINE_YAXIS15,puzzle.getDescendingDiagonalRows().get(15));
		assertEquals(29,puzzle.getDescendingDiagonalRows().size());
	}
	
	@Test
	public void whenAllLinesOfTextAreReadEnsureTheCorrectAscendingDiagonalRowHasBeenAdded() {
		assertEquals(DIAG_LINE_0,puzzle.getAscendingDiagonalRows().get(0));
		assertEquals(DIAG_LINE_1,puzzle.getAscendingDiagonalRows().get(1));
		assertEquals(DIAG_LINE_16,puzzle.getAscendingDiagonalRows().get(16));
		assertEquals(29,puzzle.getAscendingDiagonalRows().size());
	}
	
	
	
	
}
