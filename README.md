# Quarkus Funqy - Serverless example

This repository demonstrates how to use Quarkus Funqy for GraalVM based native images in an FaaS environment.
Our goal was to have functions with a low memory footprint and extremely fast cold-start times.
## Compile native binary

> mvn package -Pnative -Dquarkus.native.container-build=true

## Sources

[Quarkus - Building native image](https://quarkus.io/guides/building-native-image)
