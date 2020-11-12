(ns api.models.core
  (:require [toucan.models :refer [defmodel IModel hydration-keys]]))

(defmodel User :users IModel (hydration-keys [_] [:user]))
(defmodel Board :boards IModel)
(defmodel Comment :comments IModel)