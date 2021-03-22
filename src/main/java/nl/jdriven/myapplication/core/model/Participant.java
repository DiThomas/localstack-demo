package nl.jdriven.myapplication.core.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Participant {
  private String userId;
  private String username;
}
