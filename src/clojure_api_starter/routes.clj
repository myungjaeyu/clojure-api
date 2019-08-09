(ns clojure-api-starter.routes
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE ANY context]]
            [compojure.route :refer [not-found]]
            [ring.util.response :refer [response]]
            [clojure-api-starter.service.user :refer [gets-user get-user create-user]]))

(defroutes routes
  (GET "/" []
    (response {:message "index"}))
  (GET "/users" []
    (response (gets-user)))
  (POST "/users" [name]
    (create-user name)
    (response {:name name}))
  (context "/users/:id" [id]
    (GET "/" []
      (response (get-user id))))
  (not-found (response {:message "not found"})))