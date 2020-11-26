(defproject api "0.1.0-SNAPSHOT"
  :main api.core
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]
                 [ring "1.7.1"]
                 [ring/ring-json "0.5.0"]
                 [ring-cors "0.1.13"]
                 [toucan "1.15.1"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [buddy/buddy-auth "2.2.0"]
                 [buddy/buddy-sign "3.2.0"]
                 [buddy/buddy-hashers "1.6.0"]
                 [environ "1.1.0"]
                 [metosin/ring-swagger "0.26.2"]
                 [metosin/ring-swagger-ui "3.36.0"]
                 [ovotech/clj-gcp "0.6.13"]]
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}})