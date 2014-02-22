(ns dashboard.gifs.cache
  (:require [clojure.java.io :as io]))

(defn cache-file [url]
  (let [output-file-name (str (.hashCode url) ".img")]
    (with-open [in  (io/input-stream url)
                out (io/output-stream output-file-name)]
      (io/copy in out)
      output-file-name)))

