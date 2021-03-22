package nl.jdriven.myapplication.config;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.*;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.util.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DynamoDBConfig {

  @Bean
  @ConfigurationProperties(prefix = "storage.dynamodb", ignoreUnknownFields = false)
  public DynamoDBRepositoryProperties repositoryProperties() {
    return new DynamoDBRepositoryProperties();
  }

  @Bean
  public AmazonDynamoDB amazonDynamoDB(DynamoDBRepositoryProperties repositoryProperties) {
    System.out.println(repositoryProperties.getEndpoint());
    return AmazonDynamoDBClientBuilder.standard()
        .withEndpointConfiguration(new EndpointConfiguration(repositoryProperties.getEndpoint(), repositoryProperties.getRegion()))
        .withCredentials(new MyAWSCredentialsProviderChain()).build();
  }

  @Bean
  public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
    return new DynamoDBMapper(amazonDynamoDB);
  }

  /*
   * Added class for loading from spring properties
   */

  public class MyAWSCredentialsProviderChain extends AWSCredentialsProviderChain {

    public MyAWSCredentialsProviderChain() {
      super(new EnvironmentVariableCredentialsProvider(), new SystemPropertiesCredentialsProvider(), new ProfileCredentialsProvider(),
          new EC2ContainerCredentialsProviderWrapper(), new SpringEnvironmentCredentialsProvider());
    }

  }

  public class SpringEnvironmentCredentialsProvider implements AWSCredentialsProvider {

    @Override
    public AWSCredentials getCredentials() {
      DynamoDBRepositoryProperties properties = repositoryProperties();
      if (StringUtils.isNullOrEmpty(properties.getAccessKeyId()) || StringUtils.isNullOrEmpty(properties.getSecretKey())) {
        throw new SdkClientException(
            "Unable to load AWS credentials from spring properties out.storage.dynamodb.accessKeyId or out.storage.dynamodb.secretKey");
      }
      return new BasicAWSCredentials(properties.getAccessKeyId(), properties.getSecretKey());
    }

    @Override
    public void refresh() {
      // no-op method for this implementation
    }

    @Override
    public String toString() {
      return getClass().getSimpleName();
    }
  }
}
