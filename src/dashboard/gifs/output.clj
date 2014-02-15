(ns dashboard.gifs.output
  (:require [hiccup.core :as h]))

(defn output-html [item]
  (h/html [:html
           [:body
            [:h1 (:title item)]
            [:img {:src (:image-url item)}]
            [:address (:source item)]]]))

