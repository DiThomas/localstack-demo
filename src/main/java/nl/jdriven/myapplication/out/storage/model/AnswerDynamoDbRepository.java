package nl.jdriven.myapplication.out.storage.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.Select;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class AnswerDynamoDbRepository {
    private final DynamoDBMapper dynamoDBMapper;

    AnswerDynamoDbRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

   public void save(Answer answer) {
        dynamoDBMapper.save(answer);
    }

    public Optional<Answer> findOne(String hashKey, String rangeKey) {
        return Optional.ofNullable(dynamoDBMapper.load(Answer.class, hashKey, rangeKey));
    }

    public List<Answer> findAllAnswersById(String answerId) {
        Answer partitionKey = new Answer();
        partitionKey.setQuestionId(answerId);
        DynamoDBQueryExpression<Answer> queryExpression = new DynamoDBQueryExpression<Answer>()
                .withHashKeyValues(partitionKey)
                .withSelect(Select.ALL_ATTRIBUTES)
                .withIndexName("quizIndex")
                .withConsistentRead(false);

        PaginatedQueryList<Answer> queryList = dynamoDBMapper.query(Answer.class, queryExpression);
        return queryList != null ? queryList : Collections.emptyList();
    }
}
