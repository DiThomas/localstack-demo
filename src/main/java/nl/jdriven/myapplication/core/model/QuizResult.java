package nl.jdriven.myapplication.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class QuizResult {
    private int position;
    private String username;
    private int goodAnswers;
    private int endQuestionDifference;
}
