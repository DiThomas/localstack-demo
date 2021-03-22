package nl.jdriven.myapplication.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import nl.jdriven.myapplication.core.model.Question;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionRequest {
private String username;
private String answer;
}
