FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY /target/ROOT.war /ROOT.war
CMD ["java","-jar","/ROOT.war"]