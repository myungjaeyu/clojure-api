(defproject clojure-api-starter "0.1.0-SNAPSHOT"
  :main clojure-api-starter.core
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.json "0.2.6"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]
                 [ring "1.7.1"]
                 [ring/ring-json "0.5.0"]
                 [ring-cors "0.1.13"]
                 [toucan "1.12.0"]
                 [org.postgresql/postgresql "42.2.5"]]
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}})