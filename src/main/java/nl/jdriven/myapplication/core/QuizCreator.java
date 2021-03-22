package nl.jdriven.myapplication.core;

import nl.jdriven.myapplication.core.model.Participant;
import nl.jdriven.myapplication.core.model.Question;
import nl.jdriven.myapplication.core.model.QuestionType;
import nl.jdriven.myapplication.core.model.Quiz;
import nl.jdriven.myapplication.core.model.Round;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
class QuizCreator {

  public Quiz createQuiz(int amountOfRounds) {
    List<Round> rounds = createRounds(amountOfRounds);
    List<Participant> participants = Collections.emptyList();

    return Quiz.builder().Id(createRandomId()).rounds(rounds).participants(participants).build();
  }

  private List<Round> createRounds(int amountOfRounds) {
    if (amountOfRounds <= 0) {
      return Collections.emptyList();
    }
    List<Round> rounds = new ArrayList<>();
    for (int index = 0; index < amountOfRounds; index++) {
      rounds.add(createRound());
    }
    return rounds;
  }

  private Round createRound() {
    List<Question> questions = createQuestions();

    return Round.builder()
        .questions(questions)
        .receivedSubmissions(Collections.emptyList())
        .roundId(UUID.randomUUID().toString())
        .build();
  }

  private List<Question> createQuestions() {
    Question question1 = Question.builder()
        .questionId("1")
        .questionType(QuestionType.MULTIPLE_CHOICE)
        .answers(List.of("CORRECT", "FALSE", "INCORRECT"))
        .correctAnswer("CORRECT")
        .build();
    Question question2 = Question.builder()
        .questionId("1")
        .questionType(QuestionType.MULTIPLE_CHOICE)
        .answers(List.of("CORRECT", "FALSE", "INCORRECT"))
        .correctAnswer("CORRECT")
        .build();

    return List.of(question1, question2);
  }

  private String createRandomId() {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();

    return random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}
