(ns clojure-api-starter.routes.internal.user
  (:require [compojure.core :refer [GET POST PUT DELETE ANY context]]
            [ring.util.response :refer [response]]
            [clojure-api-starter.service.user :refer [get-users get-user create-user delete-user]]))

(defn user-routes []
  (context "/users" []
    (GET "/" []
      (response (get-users)))
    (POST "/" [name]
      (response (create-user name)))
    (context "/:id" [id]
      (GET "/" []
        (response (get-user id)))
      (DELETE "/" []
        (response (delete-user id))))))