FROM docker.elastic.co/logstash/logstash:alpine

ADD logstash.conf /
ADD docker-entrypoint.sh /

CMD["sh" , "./docker-entrypoint.sh"]
