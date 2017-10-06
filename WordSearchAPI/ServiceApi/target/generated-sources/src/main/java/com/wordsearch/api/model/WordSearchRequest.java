package com.wordsearch.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * WordSearchRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-06T09:32:04.017-04:00")

public class WordSearchRequest   {
  private List<String> words = new ArrayList<String>();

  private List<String> puzzle = new ArrayList<String>();

  public WordSearchRequest words(List<String> words) {
    this.words = words;
    return this;
  }

  public WordSearchRequest addWordsItem(String wordsItem) {
    this.words.add(wordsItem);
    return this;
  }

   /**
   * Get words
   * @return words
  **/
  @ApiModelProperty(value = "")
  public List<String> getWords() {
    return words;
  }

  public void setWords(List<String> words) {
    this.words = words;
  }

  public WordSearchRequest puzzle(List<String> puzzle) {
    this.puzzle = puzzle;
    return this;
  }

  public WordSearchRequest addPuzzleItem(String puzzleItem) {
    this.puzzle.add(puzzleItem);
    return this;
  }

   /**
   * Get puzzle
   * @return puzzle
  **/
  @ApiModelProperty(value = "")
  public List<String> getPuzzle() {
    return puzzle;
  }

  public void setPuzzle(List<String> puzzle) {
    this.puzzle = puzzle;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WordSearchRequest wordSearchRequest = (WordSearchRequest) o;
    return Objects.equals(this.words, wordSearchRequest.words) &&
        Objects.equals(this.puzzle, wordSearchRequest.puzzle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(words, puzzle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WordSearchRequest {\n");
    
    sb.append("    words: ").append(toIndentedString(words)).append("\n");
    sb.append("    puzzle: ").append(toIndentedString(puzzle)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

