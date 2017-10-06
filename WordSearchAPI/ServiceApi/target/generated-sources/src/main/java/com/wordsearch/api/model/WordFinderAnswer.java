package com.wordsearch.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.wordsearch.api.model.WordFinderAnswerLocation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * WordFinderAnswer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-06T09:32:04.017-04:00")

public class WordFinderAnswer   {
  private String word = null;

  private List<WordFinderAnswerLocation> location = new ArrayList<WordFinderAnswerLocation>();

  public WordFinderAnswer word(String word) {
    this.word = word;
    return this;
  }

   /**
   * Get word
   * @return word
  **/
  @ApiModelProperty(value = "")
  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public WordFinderAnswer location(List<WordFinderAnswerLocation> location) {
    this.location = location;
    return this;
  }

  public WordFinderAnswer addLocationItem(WordFinderAnswerLocation locationItem) {
    this.location.add(locationItem);
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")
  public List<WordFinderAnswerLocation> getLocation() {
    return location;
  }

  public void setLocation(List<WordFinderAnswerLocation> location) {
    this.location = location;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WordFinderAnswer wordFinderAnswer = (WordFinderAnswer) o;
    return Objects.equals(this.word, wordFinderAnswer.word) &&
        Objects.equals(this.location, wordFinderAnswer.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(word, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WordFinderAnswer {\n");
    
    sb.append("    word: ").append(toIndentedString(word)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
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

