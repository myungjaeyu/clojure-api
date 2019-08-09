FROM clojure:openjdk-11-lein

WORKDIR /usr/server

RUN lein version

EXPOSE 3000

CMD lein run