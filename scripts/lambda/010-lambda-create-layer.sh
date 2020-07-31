$ aws lambda publish-layer-version --layer-name my-layer \
                                   --description "My layer" \
                                   --license-info "MIT" \
                                   --content S3Bucket=lambda-layers-us-east-2-123456789012,S3Key=layer.zip \
                                   --compatible-runtimes python3.6 python3.7
# {
#     "Content": {
#         "Location": "https://awslambda-us-east-2-layers.s3.us-east-2.amazonaws.com/snapshots/123456789012/my-layer-4aaa2fbb-ff77-4b0a-ad92-5b78a716a96a?versionId=27iWyA73cCAYqyH...",
#         "CodeSha256": "tv9jJO+rPbXUUXuRKi7CwHzKtLDkDRJLB3cC3Z/ouXo=",
#         "CodeSize": 169
#     },
#     "LayerArn": "arn:aws:lambda:us-east-2:123456789012:layer:my-layer",
#     "LayerVersionArn": "arn:aws:lambda:us-east-2:123456789012:layer:my-layer:1",
#     "Description": "My layer",
#     "CreatedDate": "2018-11-14T23:03:52.894+0000",
#     "Version": 1,
#     "LicenseInfo": "MIT",
#     "CompatibleRuntimes": [
#         "python3.6",
#         "python3.7",
#         "python3.8"
#     ]
# }



# List Layers:
aws lambda list-layers --compatible-runtime python3.8