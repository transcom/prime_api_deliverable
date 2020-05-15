## Sample Java Client

### About
This sample java client uses the Swagger Codgen library and the OpenAPI 2.0 spec to auto-generate a Java client.  The entire sample-java-client directory is auto-generated using `prime.yaml`, including the enclosed README.

### How to Generate
You can regenerate the client files using the `swagger-codegen` cli. This process has been tested with the following dependencies:
* swagger-codegen 2.3.1 
* jdk8
* maven 3.5.3

Other versions may require additional troubleshooting.

```bash

# Download swagger-codegen 2.3.1
wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar




```

## Swagger and Servers
If you need additional resources on setting up your server of choice with Swagger, the swagger-codegen repo has a [directory of server examples here](https://github.com/swagger-api/swagger-codegen/tree/master/samples/server).


## Docker
You can also generate the files inside a Docker container, if you use Docker for development. Below is a sample Dockerfile to get you started. 

```dockerfile
FROM maven:3.5.3-jdk-8-alpine
# project dir
ENV TARGET_DIR=/tmp/codegen/mygenerator
RUN mkdir -p $TARGET_DIR
WORKDIR $TARGET_DIR
# generated code location
ENV GENERATED_CODE_DIR=generated
RUN mkdir -p $GENERATED_CODE_DIR
# download swagger-codegen 2.3.1 version
RUN wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.3.1/swagger-codegen-cli-2.3.1.jar -O swagger-codegen-cli.jar
# download the latest prime.yaml file from transcom
RUN wget https://raw.githubusercontent.com/transcom/mymove/master/swagger/prime.yaml
# use swagger-codegen to generate the java client files
RUN java -jar swagger-codegen-cli.jar generate -i prime.yaml -l java -o $GENERATED_CODE_DIR
WORKDIR $GENERATED_CODE_DIR
# ENTRYPOINT mvn clean install
ENTRYPOINT mvn clean install

```