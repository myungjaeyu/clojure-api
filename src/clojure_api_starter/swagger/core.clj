(ns clojure-api-starter.swagger.core
  (:require [ring.swagger.swagger2 :as rs]
            [schema.core :as s]))

(s/defschema User
  {:id s/Int
   :name s/Str})

(s/defschema CreateUserPayload
  {:name s/Str})

(def swagger-json
  (rs/swagger-json {:info {:title       "Clojure API"
                           :description "Clojure API description"}
                    :tags [{:name "user"
                            :description "User"}]
                    :paths {"/users" {:post {:summary "User Create Api"
                                             :description "User Create Api description"
                                             :tags ["user"]
                                             :parameters {:body CreateUserPayload}
                                             :responses {200 {:schema User}}}
                                      :get {:summary "Users Get Api"
                                            :description "User Get Api description"
                                            :tags ["user"]
                                            :responses {200 {:schema [User]}}}}
                            "/users/:id" {:get {:summary "User Get Api"
                                                :description "User Get Api description"
                                                :tags ["user"]
                                                :parameters {:path {:id s/Int}}
                                                :responses {200 {:schema [User]}}}
                                          :delete {:summary "User Delete Api"
                                                   :description "User Delete Api description"
                                                   :tags ["user"]
                                                   :parameters {:path {:id s/Int}}
                                                   :responses {200 {:schema nil}}}}}}))