(ns api.core
  (:use org.httpkit.server)
  (:require [compojure.handler :refer [api]]
            [ring.middleware.json :refer [wrap-json-params wrap-json-response]]
            [ring.middleware.cors :refer [wrap-cors]]
            [buddy.auth.middleware :refer [wrap-authentication]]
            [ring.swagger.swagger-ui :as swagger]
            [api.routes.core :refer [routes]]
            [api.service.auth.core :refer [backend]]
            [api.service.db :refer [db-conn db-root-namespace]]
            [ring.middleware.reload :refer [wrap-reload]])
  (:gen-class))

(def app
  (-> (api routes)
      (swagger/wrap-swagger-ui {:path "/docs"})
      wrap-json-params
      wrap-json-response
      (wrap-authentication backend)
      (wrap-cors :access-control-allow-origin [#".*"]
                 :access-control-allow-methods [:get :put :post :delete])))

(defn -main []
  (db-conn)
  (db-root-namespace)
  (run-server (wrap-reload #'app) {:port 3000})
  (println "api"))