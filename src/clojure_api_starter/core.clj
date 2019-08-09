(ns clojure-api-starter.core
  (:use org.httpkit.server)
  (:require [compojure.handler :refer [api]]
            [ring.middleware.json :refer [wrap-json-params wrap-json-response]]
            [ring.middleware.cors :refer [wrap-cors]]
            [clojure-api-starter.routes :refer [routes]]
            [ring.middleware.reload :refer [wrap-reload]]
            [clojure-api-starter.service.db :refer [db-conn db-root-namespace]])
  (:gen-class))

(def app
  (-> (api routes)
      wrap-json-params
      wrap-json-response
      (wrap-cors :access-control-allow-origin [#".*"]
                 :access-control-allow-methods [:get :put :post :delete])))

(defn -main []
  (db-conn)
  (db-root-namespace)
  (run-server (wrap-reload #'app) {:port 3000})
  (println "clojure-api-starter"))