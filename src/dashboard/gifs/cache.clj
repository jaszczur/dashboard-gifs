(ns dashboard.gifs.cache
  (:require [clojure.java.io :as io]))

(defn- short-file-name [filename]
  (str (Integer/toHexString (Math/abs (.hashCode filename))) ".img"))

(defn cache-file
  ([url] (cache-file url "/tmp"))
  ([url output-directory]
     (let [output-file-name (str output-directory "/" (short-file-name url))
           output-file      (io/file output-file-name)]
       (if-not (.exists output-file)
         (with-open [in  (io/input-stream url)
                     out (io/output-stream output-file)]
           (println "Downloading file" url)
           (io/copy in out)))
       output-file-name)))

(defn item-cached-in-dir [output-dir]
  (fn [item]
    (assoc item
      :image-url (cache-file (:image-url item) output-dir))))

