FROM markhobson/maven-chrome:jdk-8 AS build
WORKDIR /MyProject
#coping src of your framework
COPY src /MyProject/src
#coping pom file of your framework
COPY pom.xml /MyProject





