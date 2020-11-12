(ns clojure-api-starter.service.user
  (:require [toucan.db :as db]
            [clojure-api-starter.models.core :refer [User]]))

(defn get-users []
  (db/select User))

(defn get-user [id]
  (db/select-one User :id id))

(defn create-user [name]
  (db/insert! User {:name name}))

(defn delete-user [id]
  (db/delete! User :id id))