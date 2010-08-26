(defproject kundeapi "1.0.0-SNAPSHOT"
  :description "REST API til at finde kunder og kundedata, samt oprette/opdatere disse"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [compojure "0.4.1"]
                 [ring/ring-core "0.2.5"]
                 [ring/ring-servlet "0.2.5"]
                 [ring/ring-jetty-adapter "0.2.5"]
                 [ring/ring-devel "0.2.5"]
                 [ring-json-params "0.1.0"]
                 [oracle/ojdbc "1.4"]
                 [clj-json "0.2.0"]]
  :dev-dependencies
    [[uk.org.alienscience/leiningen-war "0.0.7"]]
  :namespaces [kundeapi.servlet])