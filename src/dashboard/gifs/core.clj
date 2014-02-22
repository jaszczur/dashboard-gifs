(ns dashboard.gifs.core
  (:gen-class)
  (:require [dashboard.gifs.parser :as parser]
            [dashboard.gifs.output :as output]
            [dashboard.gifs.cache  :as cache]))

(defn random-item [col]
  (let [r (rand-int (+ 1 (count col)))]
    (nth col r)))

(def cached
  (cache/item-cached-in-dir "/tmp"))

(defn parse-files [urls]
  (let [urls (if (empty? urls) ["http://thecodinglove.com/rss"] urls)]
    (flatten (map #(parser/parse-rss %1) urls))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (output/output-html
            (cached (random-item (parse-files args))))))
