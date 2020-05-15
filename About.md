# Sample Java Client

## About
This sample Java client uses the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen/tree/master) library and the OpenAPI 2.0 spec to auto-generate Java client files.  The entire `sample-java-client` directory is auto-generated using [`prime.yaml`](https://github.com/transcom/mymove/blob/master/swagger/prime.yaml), including the README.

## How to Generate
You can regenerate the client files using the `swagger-codegen` cli. This process has been tested with the following dependencies:
* [swagger-codegen 2.3.1](https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.3.1/)
* maven 3.5.3
* jdk8, jdk13

Other versions may require additional troubleshooting.

```bash

# Download swagger-codegen 2.3.1
wget https://repo1.maven.org/maven2/io/swagger/swagger-codegen-cli/2.4.13/swagger-codegen-cli-2.4.13.jar -O swagger-codegen-cli.jar

# Download latest YAML for the API
wget https://raw.githubusercontent.com/transcom/mymove/master/swagger/prime.yaml

# Generate the java client files
java -jar swagger-codegen-cli.jar generate -i prime.yaml -l java -o $GENERATED_CODE_DIR

cd $GENERATED_CODE_DIR

mvn clean install

```

### Troubleshooting
#### Error: Missing javax.annotation
When running `mvn clean install`, you may see:

```
package javax.annotation does not exist
```

This is an issue with how the pom.xml is generated. To fix, open the `pom.xml` file and find the `<dependencies>...</dependencies>` section. Add the following:

```
  <dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
  </dependency>

```

#### Error: Javadoc Plugin
After running `mvn clean install`, if you see:
```
[ERROR] Exit code: 1 - javadoc: error - The code being documented uses modules but the packages defined in http://docs.oracle.com/javase/8/docs/api/ are in the unnamed module.
```

Add the following snippet to your `maven-javadoc-plugin` in `pom.xml`: `<configuration><source>8</source></configuration>`

The section should now look similar to the following:
```
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>2.10.4</version>
                <configuration>
                  <source>8</source>
                </configuration>
                <executions>
                    <execution>
                        <id>attach-javadocs</id>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

```


## Docker
You can also generate the files inside a Docker container, if you use Docker for development. Below is a sample Dockerfile to get you started.

```dockerfile
FROM maven:3.5.3-jdk-8-alpine
# project dir
ENV TARGET_DIR=/tmp/codegen
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
ENTRYPOINT mvn clean install

```

## Resources
* If you need examples of integrating your server of choice with Swagger, the `swagger-codegen` repo has a [directory of server examples here](https://github.com/swagger-api/swagger-codegen/tree/master/samples/server).

* The auto-generated [README]() in `sample-java-client` contains additional important instructions for installing and using the API client.