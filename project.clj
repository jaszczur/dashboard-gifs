(defproject dashboard-gifs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [org.clojure/clojure "1.5.1"]
                 [org.clojure/data.zip "0.1.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 [hiccup "1.0.5"]]
  :main ^:skip-aot dashboard.gifs.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
