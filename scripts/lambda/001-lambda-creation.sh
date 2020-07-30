# 1.) Create Role
aws iam create-role --role-name lambda-ex \
                    --assume-role-policy-document file://trust-policy.json
# Role:
#   Arn: arn:aws:iam::227128452725:role/lambda-ex
#   AssumeRolePolicyDocument:
#     Statement:
#     - Action: sts:AssumeRole
#       Effect: Allow
#       Principal:
#         Service: lambda.amazonaws.com
#     Version: '2012-10-17'
#   CreateDate: '2020-07-30T06:45:14+00:00'
#   Path: /
#   RoleId: AROATJYPJEZ2ZQKGXGJID
#   RoleName: lambda-ex

# 2.) Attach Policy to the role
aws iam attach-role-policy --role-name lambda-ex \
                           --policy-arn arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole
# 3.) Create a function
# pack artifact
zip function.zip index.js
# call AWS CLI to create a function
ACCOUNT_ID="227128452725"
aws lambda create-function --function-name my-function \
                           --zip-file fileb://function.zip \
                           --handler index.handler \
                           --runtime nodejs12.x \
                           --role arn:aws:iam::${ACCOUNT_ID}:role/lambda-ex


# 4.) List a function
aws lambda list-functions

# 5.) Invoke the function and print log
aws lambda invoke --function-name my-function out --log-type Tail \
                                                  --query 'LogResult' \
                                                  --output text |  base64 -d