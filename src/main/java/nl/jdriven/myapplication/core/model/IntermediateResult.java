package nl.jdriven.myapplication.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class IntermediateResult {
    private String userName;
    private int goodAnswers;
    private int differenceLastQuestion;
}
