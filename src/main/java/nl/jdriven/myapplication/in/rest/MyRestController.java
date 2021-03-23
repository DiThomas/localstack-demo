package nl.jdriven.myapplication.in.rest;

import lombok.RequiredArgsConstructor;
import nl.jdriven.myapplication.out.storage.model.Answer;
import nl.jdriven.myapplication.out.storage.model.AnswerDynamoDbRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MyRestController {

  private final AnswerDynamoDbRepository answerDynamoDbRepository;
  @GetMapping(path = "/api/ping")
  public Answer pingPong(){
    Answer answer = Answer.builder()
            .hashKey(Answer.assembleHashKey("010917", "thomas"))
            .questionId("010917")
            .username("thomas")
            .answer("APPEL")
            .build();
    answerDynamoDbRepository.save(answer);
    return answerDynamoDbRepository.findOne("010917.thomas", "010917").get();
  }
}
