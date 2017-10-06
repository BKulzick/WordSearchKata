package com.wordsearch.api.api;

import com.wordsearch.api.model.WordSearchResponse;
import com.wordsearch.api.model.WordSearchRequest;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-06T09:32:04.017-04:00")

@Controller
public class SearchApiController implements SearchApi {

    public ResponseEntity<WordSearchResponse> searchForAllWords(

@ApiParam(value = "Words and Puzzle" ,required=true ) @RequestBody WordSearchRequest body

) {
        // do some magic!
        return new ResponseEntity<WordSearchResponse>(HttpStatus.OK);
    }

}
