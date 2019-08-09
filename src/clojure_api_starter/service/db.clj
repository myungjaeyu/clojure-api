(ns clojure-api-starter.service.db
  (:require [toucan.db :as db]
            [toucan.models :as models]))

(defn db-conn []
  (db/set-default-db-connection! {:dbtype "postgres"
                                  :dbname "postgres"
                                  :user "postgres"
                                  :host "localhost"
                                  :password "postgres"}))

(defn db-root-namespace []
  (models/set-root-namespace! 'clojure-api-starter.models))