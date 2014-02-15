(ns dashboard.gifs.output_test
  (:require [clojure.test :refer :all]
            [dashboard.gifs.output :refer :all]))

(def sample-data
  {:source "DevOps Reactions"
   :title "Explaining how git, gerrit, and jenkins work together"
   :image-url "http://31.tumblr.com/69/tumblr_inline_n0kq.gif"})

(defn html-result [] (output-html sample-data))

(defn should-contain [string substring]
  (is (.contains string substring) (str "should contain '" substring "' but was: " string)))

(deftest html-output
    (testing "should contain proper data"
      (should-contain (html-result) (str "<address>" (:source sample-data) "</address>"))
      (should-contain (html-result) (str "<h1>" (:title sample-data) "</h1>"))
      (should-contain (html-result) (str "<img src=\"" (:image-url sample-data) "\""))))

