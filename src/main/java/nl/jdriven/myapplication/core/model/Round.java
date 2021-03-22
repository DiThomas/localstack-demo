package nl.jdriven.myapplication.core.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Round {
  private String roundId;
  private List<Question> questions;
  private List<Participant> receivedSubmissions;
}
