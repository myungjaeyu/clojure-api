(defproject clojure-api-starter "0.1.0-SNAPSHOT"
  :main clojure-api-starter.core
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]
                 [ring "1.7.1"]
                 [ring/ring-json "0.5.0"]
                 [ring-cors "0.1.13"]
                 [org.clojure/java.jdbc "0.7.10"]
                 [yesql "0.5.3"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [environ "1.1.0"]]
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}})