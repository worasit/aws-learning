# 1.) Delete a function
aws lambda delete-function --function-name my-function

# 2.) Delete a log group in CloudWatch
aws logs delete-log-group --log-group-name /aws/lambda/my-function

# 3.) Detach a function role-policy
aws iam detach-role-policy --role-name lambda-ex \
                           --policy-arn arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole

# 4.) Delete a role
aws iam delete-role --role-name lambda-ex



