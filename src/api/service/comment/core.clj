(ns api.service.comment.core
  (:require [toucan.db :as db]
            [toucan.hydrate :refer [hydrate] :as hydrate]
            [api.models.core :refer [Comment]]))

(defn get-comments []
  (hydrate (db/select Comment)
           :user))

(defn get-comment [id]
  (hydrate (db/select-one Comment :id id)
           :user))

(defn create-comment [user_id board_id content]
  (db/insert! Comment {:user_id user_id
                       :board_id board_id
                       :content content}))

(defn delete-comment [id]
  (db/delete! Comment :id id))