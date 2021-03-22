package nl.jdriven.myapplication.out.storage;

import nl.jdriven.myapplication.core.model.Quiz;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QuizStorage {

  private static int correctLastAnswer = 47;
  private static final Map<String, String> CORRECT_ANSWER_MAP = Map.of("1", "LIMONCELLO",
          "2", "CLOUDFRONT",
          "3", "CLOUDFORMATION",
          "4", "B",
          "5", "" + correctLastAnswer
  );
  private Quiz storedQuiz = null;

  public void storeQuiz(Quiz newQuiz){
      this.storedQuiz = newQuiz;
  }

  public Quiz getQuiz() {
    return this.storedQuiz;
  }


  public Map<String, String> getCorrectAnswers() {
    return CORRECT_ANSWER_MAP;
  }
}
