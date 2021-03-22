package nl.jdriven.myapplication.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DynamoDBRepositoryProperties {
  private String endpoint;
  private String region;
  private String accessKeyId;
  private String secretKey;
}
