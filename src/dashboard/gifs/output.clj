(ns dashboard.gifs.output
  (:require [hiccup.page :as h]))

(def style
  "body {
     text-align: center;
     font-size: 20px;
     font-family: sans-serif;
     font-weight: bold;
   }")

(defn output-html [item]
  (h/html5 [:html
           [:head
            [:title "Dashboard GIFs"]
            [:style {:type "text/css"} style]]
           [:body
            [:h1 (:title item)]
            [:img {:src (:image-url item)}]
            [:address (:source item)]]]))

