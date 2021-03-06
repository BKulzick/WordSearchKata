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
		public String getWord(String word) {
			return word;
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
		public String getWord(String word) {
			return new StringBuilder(word).reverse().toString();
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
		public String getWord(String word) {
			return new StringBuilder(word).reverse().toString();
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
		public String getWord(String word) {
			return word;
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
		public String getWord(String word) {
			return word;
		}
	}, DIAGONAL_DESCENDING_BACKWARD{
		public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation,int lengthOfPuzzle) {
			ArrayList<Point> wordLocation = new ArrayList<>();
			int startX = row+initialLocation;
			int startY = row+initialLocation;
			if(row>=lengthOfPuzzle) {row=(row-lengthOfPuzzle)+initialLocation;}
			for (int i = 0; i < word.length(); i++) {
				wordLocation.add(new Point(startX-i, startY-i));
			}
			return wordLocation;
		}

		public List<String> getRow(WordPuzzle puzzle) {
			return puzzle.getDescendingDiagonalRows();
		}
		public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
			return puzzleLine.indexOf(word)+word.length()-1;
		}
		public String getWord(String word) {
			return new StringBuilder(word).reverse().toString();
		}
	}, DIAGONAL_ASCENDING_BACKWARD{
		public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation,int lengthOfPuzzle) {
			ArrayList<Point> wordLocation = new ArrayList<>();
			int lengthOfRow = lengthOfPuzzle-row;
			int startX = lengthOfRow-lengthOfPuzzle+row+initialLocation;
			int startY = lengthOfRow-(initialLocation+1);
			if (row>14) {startX++; startY=startY+lengthOfPuzzle; }
			for (int i = 0; i < word.length(); i++) {
				wordLocation.add(new Point(startX -i, startY+i));
			}
			return wordLocation;
		}

		public List<String> getRow(WordPuzzle puzzle) {
			return puzzle.getAscendingDiagonalRows();
		}
		
		public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
			return puzzleLine.indexOf(word)+word.length()-1;
		}
		
		public String getWord(String word) {
			return new StringBuilder(word).reverse().toString();
		}
	};

	public ArrayList<Point> buildLocations(String word, int row, Integer initialLocation, int lengthOfPuzzle) {
		return null;
	}

	public List<String> getRow(WordPuzzle puzzle) {
		return null;
	}

	public Integer findLocationOfWordInPuzzle(String word, String puzzleLine) {
		return null;
	}

	public String getWord(String word) {
		return null;
	}
	
}
