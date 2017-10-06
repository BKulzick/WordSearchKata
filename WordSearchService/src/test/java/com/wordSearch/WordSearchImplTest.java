package com.wordSearch;

import static com.wordSearch.utils.MockWordPuzzleCreator.buildMockWordPuzzle;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.wordSearch.model.WordFinderAnswer;
import com.wordSearch.utils.WordPuzzleConverter;
import com.wordSearch.utils.WordSearchFileReader;
import com.wordsearch.api.model.WordSearchRequest;
import com.wordsearch.api.model.WordSearchResponse;

public class WordSearchImplTest {

	private static final String PILLAR_BACKWARDS_AT_SPOT_6 = "IRALLIPZ";
	private static final String PILLAR = "PILLAR";
	private static final String RESOURCES_WORDSEARCH_TXT = "resources/wordsearch.txt";
	private static final String ANSWER= "[BONES: (0,6),(0,7),(0,8),(0,9),(0,10), KHAN: (5,9),(5,8),(5,7),(5,6), KIRK: (4,7),(3,7),(2,7),(1,7), SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5), SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5), SULU: (3,3),(2,2),(1,1),(0,0), UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)]";
	private List<WordFinderAnswer> answer;
	private WordSearchImpl impl;
	
	@Before
	public void setup() {
		impl = new WordSearchImpl();
		WordSearchFileReader mockReader = mock(WordSearchFileReader.class);
		Mockito.when(mockReader.classreadLinesFromThisFile(Mockito.anyString())).thenReturn(buildMockWordPuzzle());
		WordPuzzleConverter puzzleConverter = new WordPuzzleConverter();
		puzzleConverter.setReader(mockReader);
		impl.setPuzzleConverter(puzzleConverter);
		answer = impl.solveThisPuzzle(RESOURCES_WORDSEARCH_TXT);
		
	}
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheFirstWordLocationVerticalFowards() {
		assertTrue(answer.get(0).getIsWordFound());
		assertEquals(0, answer.get(0).getWordLocation().get(0).getX(), .01);
		assertEquals(6, answer.get(0).getWordLocation().get(0).getY(), .01);
		assertEquals(0, answer.get(0).getWordLocation().get(1).getX(), .01);
		assertEquals(7, answer.get(0).getWordLocation().get(1).getY(), .01);
		assertEquals(0, answer.get(0).getWordLocation().get(4).getX(), .01);
		assertEquals(10, answer.get(0).getWordLocation().get(4).getY(), .01);
	}
	
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheSecondWordLocationVerticalBackwards() {
		assertTrue(answer.get(1).getIsWordFound());
		assertEquals(5, answer.get(1).getWordLocation().get(0).getX(), .01);
		assertEquals(9, answer.get(1).getWordLocation().get(0).getY(), .01);
		assertEquals(5, answer.get(1).getWordLocation().get(1).getX(), .01);
		assertEquals(8, answer.get(1).getWordLocation().get(1).getY(), .01);
		assertEquals(5, answer.get(1).getWordLocation().get(3).getX(), .01);
		assertEquals(6, answer.get(1).getWordLocation().get(3).getY(), .01);
	}
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheThirdLocationHorizontalBackwords() {
		assertTrue(answer.get(2).getIsWordFound());
		assertEquals(4, answer.get(2).getWordLocation().get(0).getX(), .01);
		assertEquals(7, answer.get(2).getWordLocation().get(0).getY(), .01);
		assertEquals(3, answer.get(2).getWordLocation().get(1).getX(), .01);
		assertEquals(7, answer.get(2).getWordLocation().get(1).getY(), .01);
		assertEquals(1, answer.get(2).getWordLocation().get(3).getX(), .01);
		assertEquals(7, answer.get(2).getWordLocation().get(3).getY(), .01);
	}
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheFourthLocationHorizontalForwards() {
		assertTrue(answer.get(3).getIsWordFound());
		assertEquals(0, answer.get(3).getWordLocation().get(0).getX(), .01);
		assertEquals(5, answer.get(3).getWordLocation().get(0).getY(), .01);
		assertEquals(1, answer.get(3).getWordLocation().get(1).getX(), .01);
		assertEquals(5, answer.get(3).getWordLocation().get(1).getY(), .01);
		assertEquals(5, answer.get(3).getWordLocation().get(5).getX(), .01);
		assertEquals(5, answer.get(3).getWordLocation().get(5).getY(), .01);
	}
	
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheFifthLocationDiagonalDescending() {
		assertEquals("SPOCK",answer.get(4).getWord());
		assertTrue(answer.get(4).getIsWordFound());
		assertEquals(2, answer.get(4).getWordLocation().get(0).getX(), .01);
		assertEquals(1, answer.get(4).getWordLocation().get(0).getY(), .01);
		assertEquals(3, answer.get(4).getWordLocation().get(1).getX(), .01);
		assertEquals(2, answer.get(4).getWordLocation().get(1).getY(), .01);
		assertEquals(6, answer.get(4).getWordLocation().get(4).getX(), .01);
		assertEquals(5, answer.get(4).getWordLocation().get(4).getY(), .01);
	}
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheSixthLocationDiagonalDescendingBackwards() {
		assertTrue(answer.get(5).getIsWordFound());
		assertEquals(3, answer.get(5).getWordLocation().get(0).getX(), .01);
		assertEquals(3, answer.get(5).getWordLocation().get(0).getY(), .01);
		assertEquals(2, answer.get(5).getWordLocation().get(1).getX(), .01);
		assertEquals(2, answer.get(5).getWordLocation().get(1).getY(), .01);
		assertEquals(0, answer.get(5).getWordLocation().get(3).getX(), .01);
		assertEquals(0, answer.get(5).getWordLocation().get(3).getY(), .01);
	}
	
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheSeventhLocationDiagonalAscendingBackwards() {
		assertTrue(answer.get(6).getIsWordFound());
		assertEquals("UHURA",answer.get(6).getWord());
		assertEquals(4, answer.get(6).getWordLocation().get(0).getX(), .01);
		assertEquals(0, answer.get(6).getWordLocation().get(0).getY(), .01);
		assertEquals(3, answer.get(6).getWordLocation().get(1).getX(), .01);
		assertEquals(1, answer.get(6).getWordLocation().get(1).getY(), .01);
		assertEquals(0, answer.get(6).getWordLocation().get(4).getX(), .01);
		assertEquals(4, answer.get(6).getWordLocation().get(4).getY(), .01);
	}
	
	@Test
	public void whenAPuzzleIsReadReturnAnArrayOfTheFullAnswer() {
		assertEquals(ANSWER,answer.toString());
	}
	@Test
	public void whenAWebServiceRequestIsReceievedReturnAnswer() {
		WordSearchRequest body = new WordSearchRequest();
		String wordsItem = PILLAR;
		body.addWordsItem(wordsItem);
		body.addPuzzleItem(PILLAR_BACKWARDS_AT_SPOT_6);
		ResponseEntity<WordSearchResponse> response = impl.searchForAllWords(body);
		
		assertEquals(PILLAR,response.getBody().getAnswer().get(0).getWord());
		assertEquals(6,response.getBody().getAnswer().get(0).getLocation().get(0).getX(),.01);
		assertEquals(0,response.getBody().getAnswer().get(0).getLocation().get(0).getY(),.01);

	}

	
}
