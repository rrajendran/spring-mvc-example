FROM rameshr/alpine-jdk8:latest


ENV ELASTIC_SEARCH_VERSION=5.5.2 \
    ELASTIC_SEARCH_HOME=/opt/elasticsearch \
    JAVA_HOME=/opt/jdk

ADD elasticsearch-5.5.2.tar.gz /opt
RUN mv /opt/elasticsearch-5.5.2  ${ELASTIC_SEARCH_HOME}
#RUN curl -L -O https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-${ELASTIC_SEARCH_VERSION}.tar.gz && \
 #   tar -xvf elasticsearch-${ELASTIC_SEARCH_VERSION}.tar.gz && \
  #  mv elasticsearch-${ELASTIC_SEARCH_VERSION} ${ELASTIC_SEARCH_HOME} && \

EXPOSE 9200
EXPOSE 9300
VOLUME /opt/elasticsearch/data
#ENTRYPOINT ["/opt/elasticsearch/bin/elasticsearch"]
CMD [""]
