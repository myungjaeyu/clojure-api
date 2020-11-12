(ns clojure-api-starter.routes.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.util.response :refer [response]]
            [clojure-api-starter.swagger.core :refer [swagger-json]]
            [clojure-api-starter.routes.internal.user :refer [user-routes]]))

(defroutes routes
  (GET "/" []
    (response {:message "index"}))
  (GET "/swagger.json" []
    (response swagger-json))
  (user-routes)
  (not-found (response {:message "not found"})))