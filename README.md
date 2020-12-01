# Quarkus Funqy - Serverless example

This repository demonstrates how to use Quarkus Funqy for GraalVM based native images in an FaaS environment.
Our goal was to have functions with a low memory footprint and extremely fast cold-start times.
## Compile native binary

> mvn package -Pnative -Dquarkus.native.container-build=true

## AWS
Specify your function in the ``application.properties`` with ``quarkus.funqy.export=helloWorld``.

The function name is based on the function in the ``HelloWorldFunction.class`` in the case it`s ``helloWorld``.

You need to add ``LAMBDA_ROLE_ARN`` with your role to your enviroment variables or add it to the ``manage.sh`` file.

### Native deployment

> mvn package -Pnative -Dquarkus.native.container-build=true

> sh target/manage.sh native create

## Testing
You can use the SAM CLI to test your aws lamda locally.

### JVM
> sam local invoke --template target/sam.jvm.yaml --event payload.json

### Native
> sam local invoke --template target/sam.native.yaml --event payload.json

## Sources

[Quarkus - Building native image](https://quarkus.io/guides/building-native-image)

[Quarkus - Funqy Amazon Lamda](https://quarkus.io/guides/funqy-amazon-lambda)
