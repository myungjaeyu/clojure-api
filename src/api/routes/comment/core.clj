(ns api.routes.comment.core
  (:require [compojure.core :refer [GET POST PUT DELETE ANY context]]
            [ring.util.response :refer [response]]
            [api.service.comment.core :refer [get-comments get-comment create-comment delete-comment]]))

(defn comment-routes []
  (context "/comments" []
    (GET "/" []
      (response (get-comments)))
    (POST "/" [user_id board_id content]
      (response (create-comment user_id board_id content)))
    (context "/:id" [id]
      (GET "/" []
        (response (get-comment id)))
      (DELETE "/" []
        (response (delete-comment id))))))