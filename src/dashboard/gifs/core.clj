(ns dashboard.gifs.core
  (:gen-class)
  (:require [clojure.xml :as xml]
            [clojure.zip :as zip]
            [clojure.data.zip.xml :as dzx]))

(defn zip-xml [file-name]
  (zip/xml-zip (xml/parse file-name)))

(defn parse-rss [file-name]
  (let [zipped (zip-xml file-name)
        items (dzx/xml-> zipped :channel :item)]
    items))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
