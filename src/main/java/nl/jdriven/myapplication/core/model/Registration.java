package nl.jdriven.myapplication.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
  private String username;
  private String quizId;
}
