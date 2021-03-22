package nl.jdriven.myapplication.in.rest.quizmaster;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuizRequest {
  int amountOfRounds;
}
