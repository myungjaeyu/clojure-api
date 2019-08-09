(ns clojure-api-starter.service.user
  (:require [toucan.db :as db]
            [clojure-api-starter.models.user :refer [User]]))

(defn gets-user []
  (db/select User))

(defn get-user [id]
  (db/select-one User :id (Integer/parseInt id)))

(defn create-user [name]
  (db/insert! User {:name name}))