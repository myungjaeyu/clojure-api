(ns api.routes.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.util.response :refer [response]]
            [api.swagger.core :refer [swagger-json]]
            [api.routes.auth.core :refer [auth-routes]]
            [api.routes.user.core :refer [user-routes]]
            [api.routes.board.core :refer [board-routes]]
            [api.routes.comment.core :refer [comment-routes]]))

(defroutes routes
  (GET "/" []
    (response {:message "index"}))
  (GET "/swagger.json" []
    (response swagger-json))
  (auth-routes)
  (user-routes)
  (board-routes)
  (comment-routes)
  (not-found (response {:message "not found"})))