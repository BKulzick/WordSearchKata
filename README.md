# WordSearchKata
This is a practice in Application Development using TDD and the Word Search Code Kata.

This project is a Maven project, so it tests are commonly ran while doing a mvn clean install, or just run a mvn test from the command line. Most tests make use of Mocks for the File Reader, except the File Reader test.  In case the File is not present when the tests run. 

I've also created an REST microservice, WordSearchAPI, that utilizes the WordSearchService.  This was created using a YAML and Swagger/Maven plug in.  The rest service takes a POST command with a JSON body containing the Words and Puzzle. The answer is returned in JSON.  If I had time I would write a validator to make sure that the request made is valid, then make use of the 405 Bad Request Exception. As it is, no validation is done. And the only error handling done is on the part of the File Reader.  

The Good - Tried to show the ability to limit the amount of repeated code using ENUMS.  Tried to use simple tools like contains, Point, etc, and not have to reinvent the wheel. I tried to think object orientated, making the Puzzle and object, and the Solution an object. Made use of Mocks so the File Reader isn't always used.  Over %97 Test Coverage, only missing getters and setters and the error handling for file reader.  Didn't feel the need to extensively test file reader since it is a java provided class.

Things I'd Impove Given Time - Already mentioned making a request validator for the micro service. I also don't like some of the complexity in the Enums, the code is not easily readable.  It was a sum of making the other parts of the code easier. 

Please contact me if you have any questions.

BryanKulczycki@gmail.com
