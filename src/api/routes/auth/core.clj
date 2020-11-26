(ns api.routes.auth.core
  (:require [compojure.core :refer [GET POST PUT DELETE ANY context]]
            [api.service.auth.core :refer [signout signin me]]
            [buddy.auth :refer [authenticated?]]
            [buddy.auth.accessrules :refer [restrict]]))

(defn auth-routes []
  (context "/auth" []
    (GET "/me" [] (restrict me {:handler authenticated?}))
    (POST "/signin" [username password] (signin username password))))