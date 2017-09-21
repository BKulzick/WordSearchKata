package com.wordSearch.model;

import java.util.ArrayList;
import java.util.List;

public class WordPuzzle {

	private List<String> horizontalRows = new ArrayList<String>();

	public List<String> getHorizontalRows() {
		return horizontalRows;
	}

	public void addLineToPuzzle(String x) {
		horizontalRows.add(x);
	}


}
