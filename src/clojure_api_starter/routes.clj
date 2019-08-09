(ns clojure-api-starter.routes
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE ANY context]]
            [compojure.route :refer [not-found]]
            [ring.util.response :refer [response]]))

(defroutes routes
  (GET "/" []
    (response {:message "index"}))
  (POST "/" [id name authentication]
    (response
     {:id id
      :name name}))
  (context "/user/:id" [id]
    (GET "/" []
      (response {:id id})))
  (not-found (response {:message "not found"})))