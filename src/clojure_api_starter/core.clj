(ns clojure-api-starter.core
  (:use org.httpkit.server)
  (:require [compojure.handler :refer [api]]
            [ring.middleware.json :refer [wrap-json-params wrap-json-response]]
            [clojure-api-starter.routes :refer [routes]])
  (:gen-class))

(def app
  (-> (api routes)
      wrap-json-params
      wrap-json-response))

(defn -main []
  (run-server app {:port 3000})
  (println "clojure-api-starter"))