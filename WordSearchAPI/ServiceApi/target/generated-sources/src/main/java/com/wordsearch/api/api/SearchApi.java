package com.wordsearch.api.api;

import com.wordsearch.api.model.WordSearchResponse;
import com.wordsearch.api.model.WordSearchRequest;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-06T09:32:04.017-04:00")

@Api(value = "search", description = "the search API")
public interface SearchApi {

    @ApiOperation(value = "This Service searches a puzzle for list of words", notes = "", response = WordSearchResponse.class, tags={ "wordSearch", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Words and Puzzle Response", response = WordSearchResponse.class),
        @ApiResponse(code = 405, message = "Bad Request exception", response = WordSearchResponse.class) })
    @RequestMapping(value = "/search",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<WordSearchResponse> searchForAllWords(

@ApiParam(value = "Words and Puzzle" ,required=true ) @RequestBody WordSearchRequest body

);

}
