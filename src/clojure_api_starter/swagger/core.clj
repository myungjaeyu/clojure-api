(ns clojure-api-starter.swagger.core
  (:require [ring.swagger.swagger2 :as rs]
            [schema.core :as s]))

(s/defschema User
  {:id s/Int
   :name s/Str})

(s/defschema Board
  {:id s/Int
   :user_id s/Int
   :title s/Str
   :content s/Str
   :hit s/Int})

(s/defschema Comment
  {:id s/Int
   :user_id s/Int
   :board_id s/Int
   :content s/Str})

(s/defschema BoardInfo
  (assoc Board
         :user User
         :comments [Comment]))

(s/defschema CommentInfo
  (assoc Comment
         :user User))

(s/defschema CreateUserPayload
  {:name s/Str})

(s/defschema CreateBoardPayload
  {:user_id s/Int
   :title s/Str
   :content s/Str})

(s/defschema CreateCommentPayload
  {:user_id s/Int
   :board_id s/Int
   :content s/Str})

(def swagger-json
  (rs/swagger-json {:info {:title       "Clojure API"
                           :description "Clojure API description"}
                    :tags [{:name "user"
                            :description "User"}
                           {:name "board"
                            :description "Board"}
                           {:name "comment"
                            :description "Comment"}]
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
                                                :responses {200 {:schema User}}}
                                          :delete {:summary "User Delete Api"
                                                   :description "User Delete Api description"
                                                   :tags ["user"]
                                                   :parameters {:path {:id s/Int}}
                                                   :responses {200 {:schema nil}}}}
                            "/boards" {:post {:summary "Board Create Api"
                                              :description "Board Create Api description"
                                              :tags ["board"]
                                              :parameters {:body CreateBoardPayload}
                                              :responses {200 {:schema Board}}}
                                       :get {:summary "Boards Get Api"
                                             :description "Boards Get Api description"
                                             :tags ["board"]
                                             :responses {200 {:schema [BoardInfo]}}}}
                            "/boards/:id" {:get {:summary "Board Get Api"
                                                 :description "Board Get Api description"
                                                 :tags ["board"]
                                                 :parameters {:path {:id s/Int}}
                                                 :responses {200 {:schema BoardInfo}}}
                                           :delete {:summary "Board Delete Api"
                                                    :description "Board Delete Api description"
                                                    :tags ["board"]
                                                    :parameters {:path {:id s/Int}}
                                                    :responses {200 {:schema nil}}}}
                            "/comments" {:post {:summary "Comment Create Api"
                                                :description "Comment Create Api description"
                                                :tags ["comment"]
                                                :parameters {:body CreateCommentPayload}
                                                :responses {200 {:schema Comment}}}
                                         :get {:summary "Comments Get Api"
                                               :description "Comments Get Api description"
                                               :tags ["comment"]
                                               :responses {200 {:schema [CommentInfo]}}}}
                            "/comments/:id" {:get {:summary "Comment Get Api"
                                                   :description "Comment Get Api description"
                                                   :tags ["comment"]
                                                   :parameters {:path {:id s/Int}}
                                                   :responses {200 {:schema CommentInfo}}}
                                             :delete {:summary "Comment Delete Api"
                                                      :description "Comment Delete Api description"
                                                      :tags ["comment"]
                                                      :parameters {:path {:id s/Int}}
                                                      :responses {200 {:schema nil}}}}}}))