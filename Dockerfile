FROM rameshr/alpine-tomcat8:latest


ADD target/*.war "$CATALINA_HOME"/webapps/app.war
ADD keycloak-tomcat8-adapter-dist-1.3.1.Final.tar.gz "$CATALINA_HOME"/lib
ADD tomcat-users.xml $CATALINA_HOME/conf

RUN mkdir -p "$CATALINA_HOME/webapps/app" && \
    unzip "$CATALINA_HOME"/webapps/app.war -d "$CATALINA_HOME"/webapps/app && \
    rm -f "$CATALINA_HOME"/webapps/app.war



ENTRYPOINT ["/opt/tomcat/bin/catalina.sh" , "run"]