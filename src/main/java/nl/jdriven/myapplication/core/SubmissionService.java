package nl.jdriven.myapplication.core;

import lombok.RequiredArgsConstructor;

import nl.jdriven.myapplication.out.storage.model.Answer;
import nl.jdriven.myapplication.out.storage.model.AnswerDynamoDbRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubmissionService {

    private final AnswerDynamoDbRepository answerDynamoDbRepository;

    public void submit(String quizId, String username, String answer){

        Answer entity = Answer.builder().hashKey(Answer.assembleHashKey(quizId, username)).questionId(quizId).username(username).answer(answer).build();
        answerDynamoDbRepository.save(entity);

    }
}
