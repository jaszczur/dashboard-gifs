(ns dashboard.gifs.core
  (:gen-class)
  (:require [dashboard.gifs.parser :as parser]
            [dashboard.gifs.output :as output]))

(defn random-item [col]
  (let [r (rand-int (+ 1 (count col)))]
    (nth col r)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (output/output-html
            (random-item (parser/parse-rss (first args))))))

