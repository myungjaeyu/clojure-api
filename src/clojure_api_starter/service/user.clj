(ns clojure-api-starter.service.user
  (:require [clojure-api-starter.service.db :as db]))

(defn gets-user []
  (db/get-users))

(defn get-user [id]
  (db/get-user {:id id}))

(defn create-user [name]
  (db/create-user<! {:name name}))