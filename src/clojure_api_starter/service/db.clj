(ns clojure-api-starter.service.db
  (:require [yesql.core :refer [defqueries]]
            [environ.core :refer [env]]))

(def db-spec {:subprotocol (env :db-type)
              :subname (str "//" (env :db-host) ":3306/" (env :db-name))
              :user (env :db-user)
              :password (env :db-password)})

(defqueries "clojure_api_starter/queries/core.sql" {:connection db-spec})