# The following example creates an alias (named routing-alias) for a Lambda function.
# The alias points to version 1 of the function. Version 2 of the function receives 3 percent of the traffic.
# The remaining 97 percent of traffic is routed to version 1.
aws lambda create-alias --name  routing-alias  \
                        --function-name  my-function \
                        --function-version  1  \
                        --routing-config  AdditionalVersionWeights={"2"=0.50}

# To route all traffic to version 2, use the UpdateAlias command to change the function-version property
# to point the alias to version 2. The command also resets the routing configuration.
aws lambda update-alias --name  routing-alias \
                        --function-name  my-function \
                        --function-version  2 \
                        --routing-config  AdditionalVersionWeights={}

# Invoke lambda with weighted alias named "routing-alias"
aws lambda invoke --function-name my-function:routing-alias out