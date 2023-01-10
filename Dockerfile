FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY /ROOT.war /ROOT.war
CMD ["java","-jar","/ROOT.war"]