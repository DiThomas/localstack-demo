package nl.jdriven.myapplication.out.storage.model;


import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;

@DynamoDBTable(tableName = "ANSWER")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    public static String assembleHashKey(String questionId, String username) {
        return String.format("%s.%s", questionId, username);
    }

    @DynamoDBHashKey
    private String hashKey;

    @DynamoDBRangeKey
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "quizIndex")
    private String questionId;
    private String answer;
    private String username;

    @DynamoDBAttribute(attributeName = "answer")
    public String getAnswer() {
        return answer;
    }
}
