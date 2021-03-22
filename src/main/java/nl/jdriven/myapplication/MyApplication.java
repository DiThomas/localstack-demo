package nl.jdriven.myapplication;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

public class MyApplication {

	public static void main(String[] args) {

		final AmazonDynamoDB amazonDynamoDBClient = getAmazonDynamoDBClient();

		CreateTableRequest request = getCreateTableRequest();

		try {
			CreateTableResult result = amazonDynamoDBClient.createTable(request);
			System.out.println(result.getTableDescription().getTableName());

		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
		}
	}

	private static AmazonDynamoDB getAmazonDynamoDBClient() {
		//Create endpoint configuration which points to Localstack DynamoDB (running on http://localhost:4569)
		AwsClientBuilder.EndpointConfiguration endpointConfig = new AwsClientBuilder.EndpointConfiguration("http://localhost:4566",
																																																			 Regions.EU_WEST_1.getName());

		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(endpointConfig)
				.build();
	}


	private static CreateTableRequest getCreateTableRequest(){
			CreateTableRequest request = new CreateTableRequest()
					.withAttributeDefinitions(new AttributeDefinition("Name", ScalarAttributeType.S))
					.withKeySchema(new KeySchemaElement("Name", KeyType.HASH))
					.withProvisionedThroughput(new ProvisionedThroughput(10L, 10L))
					.withTableName("wewew");
			return request;
		}
	}
