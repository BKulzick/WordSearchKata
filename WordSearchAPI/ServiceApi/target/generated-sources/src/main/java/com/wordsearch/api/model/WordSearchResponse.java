package com.wordsearch.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.wordsearch.api.model.WordFinderAnswer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * WordSearchResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-06T09:32:04.017-04:00")

public class WordSearchResponse   {
  private List<WordFinderAnswer> answer = new ArrayList<WordFinderAnswer>();

  public WordSearchResponse answer(List<WordFinderAnswer> answer) {
    this.answer = answer;
    return this;
  }

  public WordSearchResponse addAnswerItem(WordFinderAnswer answerItem) {
    this.answer.add(answerItem);
    return this;
  }

   /**
   * Get answer
   * @return answer
  **/
  @ApiModelProperty(value = "")
  public List<WordFinderAnswer> getAnswer() {
    return answer;
  }

  public void setAnswer(List<WordFinderAnswer> answer) {
    this.answer = answer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WordSearchResponse wordSearchResponse = (WordSearchResponse) o;
    return Objects.equals(this.answer, wordSearchResponse.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WordSearchResponse {\n");
    
    sb.append("    answer: ").append(toIndentedString(answer)).append("\n");
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

