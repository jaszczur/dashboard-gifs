(ns dashboard.gifs.core
  (:require [clojure.test :refer :all]
            [dashboard.gifs.core :refer :all]))

(defn parse-sample-file []
  (parse-rss "test/sample-rss.xml"))

(deftest a-test
  (testing "parsing rss"
    (is (= 3 (count (parse-sample-file))))))