(ns clojure-ants.core
  (:require [clojure.java.io :as io])
  (:import [javafx.application Application]
           [javafx.fxml FXMLLoader]
           [javafx.stage Stage StageBuilder]
           [javafx.scene Scene])
  (:gen-class :extends javafx.application.Application))

(defn -start [app stage]
  (let [root (FXMLLoader/load (io/resource "main.fxml"))
        scene (Scene. root 800 600)]
    (doto stage
      (.setTitle "Ants")
      (.setScene scene)
      (.show))))

(defn -main [& args]
  (Application/launch clojure_ants.core (into-array String args)))

(defn dev-main []
  (-main))

