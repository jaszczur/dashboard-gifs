(ns dashboard.gifs.core
  (:gen-class)
  (:require [clojure.xml :as xml]
            [clojure.zip :as zip]
            [clojure.data.zip.xml :as dzx]))

(defn zip-xml [file-name]
  (zip/xml-zip (xml/parse file-name)))

(defn child-text [loc child]
  (dzx/text (dzx/xml1-> loc child)))

(defn extract-img-url [text]
  (second (re-find #"src=\"(.*)\"" text)))

(defn extract-data [item]
  {:title     (child-text item :title)
   :image-url (extract-img-url (child-text item :description))})

(defn assign-source [source item]
  (assoc item :source source))

(defn assign-source-fun [source]
  (partial assign-source source))

(defn parse-rss [file-name]
  (let [zipped (zip-xml file-name)
        source (dzx/text (dzx/xml1-> zipped :channel :title))
        items  (dzx/xml-> zipped :channel :item)]
    (map (comp (assign-source-fun source) extract-data) items)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
