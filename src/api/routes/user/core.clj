(ns api.routes.user.core
  (:require [compojure.core :refer [GET POST PUT DELETE ANY context]]
            [ring.util.response :refer [response]]
            [api.service.user.core :refer [get-users get-user create-user delete-user]]))

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