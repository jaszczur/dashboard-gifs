(ns dashboard.gifs.core
  (:require [clojure.test :refer :all]
            [dashboard.gifs.core :refer :all]))

(defn parse-sample-file []
  (parse-rss "test/sample-rss.xml"))

(deftest parsing-xml
  (let [result1 (first (parse-sample-file))]
    (testing "items count"
      (is (= 3 (count (parse-sample-file)))))
    (testing "first title"
      (is (= "Explaining how git, gerrit, and jenkins work together" (:title result1))))
    (testing "first gif url"
      (is (= "http://31.tumblr.com/69/tumblr_inline_n0kq.gif" (:image-url result1))))))
