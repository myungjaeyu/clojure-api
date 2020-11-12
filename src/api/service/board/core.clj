(ns api.service.board.core
  (:require [toucan.db :as db]
            [toucan.hydrate :refer [hydrate] :as hydrate]
            [api.models.core :refer [Board Comment]]))

(defn- with-comments
  {:batched-hydrate :comments}
  [objects]
  (for [object objects]
    (assoc object
           :comments (hydrate
                      (db/select Comment :board_id (:id object))
                      :user))))

(defn get-boards []
  (hydrate (db/select Board)
           :user
           :comments))

(defn get-board [id]
  (hydrate (db/select-one Board :id id)
           :user
           :comments))

(defn create-board [user_id title content]
  (db/insert! Board {:user_id user_id
                     :title title
                     :content content}))

(defn delete-board [id]
  (db/delete! Board :id id))