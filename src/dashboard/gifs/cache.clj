(ns dashboard.gifs.cache
  (:require [clojure.java.io :as io]))

(defn- short-file-name [filename]
  (str (Integer/toHexString (Math/abs (.hashCode filename))) ".img"))

(defn cache-file
  ([url] (cache-file url "/tmp"))
  ([url output-directory]
     (let [output-file-name (str output-directory "/" (short-file-name url))]
       (with-open [in  (io/input-stream url)
                   out (io/output-stream output-file-name)]
         (io/copy in out)
         output-file-name))))

