(ns clojure-api-starter.routes.internal.board
  (:require [compojure.core :refer [GET POST PUT DELETE ANY context]]
            [ring.util.response :refer [response]]
            [clojure-api-starter.service.board :refer [get-boards get-board create-board delete-board]]))

(defn board-routes []
  (context "/boards" []
    (GET "/" []
      (response (get-boards)))
    (POST "/" [user_id title content]
      (response (create-board user_id title content)))
    (context "/:id" [id]
      (GET "/" []
        (response (get-board id)))
      (DELETE "/" []
        (response (delete-board id))))))