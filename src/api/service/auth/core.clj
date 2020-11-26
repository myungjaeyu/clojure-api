(ns api.service.auth.core
  (:require [buddy.auth.backends.token :refer [jws-backend]]
            [buddy.hashers :refer [encrypt check]]
            [buddy.auth :refer [authenticated?]]
            [buddy.sign.jwt :as jwt]
            [ring.util.response :refer [response header]]))

(def secret "apisecret")

(def backend (jws-backend {:secret secret
                           :token-name "Bearer"}))

(def users {"u4bi" {:username "u4bi"
                    :password (encrypt "u4bi123" {:alg :bcrypt+sha512})
                    :cash 20000}
            "test_kim" {:username "test_kim"
                        :password (encrypt "test123" {:alg :bcrypt+sha512})
                        :cash 15000}})

(defn check-user [username password]
  (if-let [user (get users username)]
    (if (check password (get user :password))
      (dissoc user :password))))

(defn signin [username password]
  (if-let [user (check-user username password)]
    (let [token (jwt/sign user secret)]
      (header (response {:user user
                         :token token})
              "Authorization"
              (str "Bearer " token)))
    (response {})))

(defn me [{user :identity}] (response user))