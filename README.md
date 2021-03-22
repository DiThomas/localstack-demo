# used commands:

dynamodb create-table --table-name ANSWER --attribute-definitions AttributeName=hashKey,AttributeType=S AttributeName=questionId,AttributeType=S --key-schema AttributeName=hashKey,KeyType=HASH AttributeName=questionId,KeyType=RANGE --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5



## examples simple lambda

lambda create-function --function-name MyLambdaFunction \
--runtime nodejs10.x \
--region eu-west-1 \
--role arn:aws:iam::XXXXXXXXXXXX:role/aws-lambda-execution-role \
--zip-file fileb://function.zip \
--handler index.handler


awslocal lambda invoke --function-name MyLambdaFunction \
--cli-binary-format raw-in-base64-out --payload file://event.json out.json && cat out.json

## examples Java dynamoDBStreams
s3 mb s3://my-lambda-artifacts --region eu-west-1
s3 cp my-lambda/target/my-lambda-0.0.1-SNAPSHOT-jar-with-dependencies.jar s3://my-lambda-artifacts


lambda create-function --function-name MyLambdaFunction \
--runtime java11 --region eu-west-1 \
--role arn:aws:iam::XXXXXXXXXXXX:role/aws-lambda-execution-role \
--handler nl.jdriven.mylambda.HandlerDynamoDB::handleRequest

lambda update-function-code --function-name MyLambdaFunction \
--s3-bucket my-lambda-artifacts \
--s3-key my-lambda-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
--cli-binary-format raw-in-base64-out
