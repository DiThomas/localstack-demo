package nl.jdriven.myapplication.core.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Question {
private String       questionId;
private String       question;
private QuestionType questionType;
private List<String> answers;
private String correctAnswer;

}
