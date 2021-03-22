package nl.jdriven.myapplication.core.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AnswerRequest {
    private String questionId;
    private String answer;
}
