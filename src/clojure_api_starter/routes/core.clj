(ns clojure-api-starter.routes.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.util.response :refer [response]]
            [clojure-api-starter.swagger.core :refer [swagger-json]]
            [clojure-api-starter.routes.internal.user :refer [user-routes]]
            [clojure-api-starter.routes.internal.board :refer [board-routes]]
            [clojure-api-starter.routes.internal.comment :refer [comment-routes]]))

(defroutes routes
  (GET "/" []
    (response {:message "index"}))
  (GET "/swagger.json" []
    (response swagger-json))
  (user-routes)
  (board-routes)
  (comment-routes)
  (not-found (response {:message "not found"})))