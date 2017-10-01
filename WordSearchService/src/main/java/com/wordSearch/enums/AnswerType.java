package com.wordSearch.enums;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.wordSearch.model.WordPuzzle;

public enum AnswerType {
	VERTICAL_FORWARD {
		public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation, int lengthOfPuzzle) {
			ArrayList<Point> wordLocation = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				wordLocation.add(new Point(row, initialLocation + i));
			}
			return wordLocation;
		}

		public List<String> getRow(WordPuzzle puzzle) {
			return puzzle.getVerticalRows();
		}
		
		public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
			return puzzleLine.indexOf(word);
		}

	},
	VERTICAL_BACKWARD {
		public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation,int lengthOfPuzzle) {
			ArrayList<Point> wordLocation = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				wordLocation.add(new Point(row, initialLocation - i));
			}
			return wordLocation;
		}

		public List<String> getRow(WordPuzzle puzzle) {
			return puzzle.getVerticalRows();
		}
		public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
			return puzzleLine.length()-puzzleLine.indexOf(word);
		}
	},
	HORIZONTAL_BACKWARD {
		public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation,int lengthOfPuzzle) {
			ArrayList<Point> wordLocation = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				wordLocation.add(new Point(initialLocation - i, row));
			}
			return wordLocation;
		}

		public List<String> getRow(WordPuzzle puzzle) {
			return puzzle.getHorizontalRows();
		}
		
		public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
			return puzzleLine.indexOf(word)+word.length()-1;
		}
	},
	HORIZONTAL_FORWARD {
		public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation,int lengthOfPuzzle) {
			ArrayList<Point> wordLocation = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				wordLocation.add(new Point(initialLocation +i, row));
			}
			return wordLocation;
		}

		public List<String> getRow(WordPuzzle puzzle) {
			return puzzle.getHorizontalRows();
		}
		public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
			return puzzleLine.indexOf(word);
		}
	}, DIAGONAL_DESCENDING{
		public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation,int lengthOfPuzzle) {
			ArrayList<Point> wordLocation = new ArrayList<>();
			if(row<lengthOfPuzzle) {initialLocation=initialLocation+row;}
			if(row>=lengthOfPuzzle) {row=(row-lengthOfPuzzle)+initialLocation;}
			for (int i = 0; i < word.length(); i++) {
				wordLocation.add(new Point(initialLocation +i+row, initialLocation+i));
			}
			return wordLocation;
		}

		public List<String> getRow(WordPuzzle puzzle) {
			return puzzle.getDescendingDiagonalRows();
		}
		public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
			return puzzleLine.indexOf(word);
		}
	}, DIAGONAL_DESCENDING_BACKWARD{
		public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation,int lengthOfPuzzle) {
			ArrayList<Point> wordLocation = new ArrayList<>();
			if(row<lengthOfPuzzle) {initialLocation=initialLocation+row;}
			if(row>=lengthOfPuzzle) {row=(row-lengthOfPuzzle)+initialLocation;}
			for (int i = 0; i < word.length(); i++) {
				wordLocation.add(new Point(initialLocation -i+row, initialLocation-i));
			}
			return wordLocation;
		}

		public List<String> getRow(WordPuzzle puzzle) {
			return puzzle.getDescendingDiagonalRows();
		}
		public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
			return puzzleLine.indexOf(word)+word.length()-1;
		}
	};

	public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation, int lengthOfPuzzle) {
		return null;
	}

	public List<String> getRow(WordPuzzle puzzle) {
		return null;
	}

	public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
