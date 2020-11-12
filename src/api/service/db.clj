(ns api.service.db
  (:require [toucan.db :as db]
            [toucan.models :as models]
            [environ.core :refer [env]]))

(defn db-conn []
  (db/set-default-quoting-style! :mysql)
  (db/set-default-db-connection! {:dbtype (env :db-type)
                                  :dbname (env :db-name)
                                  :user (env :db-user)
                                  :host (env :db-host)
                                  :password (env :db-password)}))

(defn db-root-namespace []
  (models/set-root-namespace! 'api.models))