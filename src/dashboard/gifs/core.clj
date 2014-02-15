(ns dashboard.gifs.core
  (:gen-class)
  (:require [dashboard.gifs.parser :as parser]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (parser/parse-rss (first args))))

