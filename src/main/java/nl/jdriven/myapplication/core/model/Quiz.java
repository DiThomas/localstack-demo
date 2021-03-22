package nl.jdriven.myapplication.core.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Quiz {
  private String      Id;
  private List<Round> rounds;
  private List<Participant> participants;
}
