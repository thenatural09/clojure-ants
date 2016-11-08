(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [nightlight "1.1.0" :scope "test"]])

(require '[nightlight.boot :refer [nightlight]])

(deftask build []
  (comp
    (aot :namespace '#{clojure-ants.core})
    (pom :project 'clojure-ants
         :version "1.0.0")
    (uber)
    (jar :main 'clojure-ants.core)
    (target)))

(deftask run []
  (comp
    (wait)
    (nightlight :port 4000)))

(deftask dev []
  (comp
    (aot :namespace '#{clojure-ants.core})
    (with-pass-thru _
      (require
        '[clojure-ants.core :refer [dev-main]])
      ((resolve 'dev-main)))))

