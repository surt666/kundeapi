(ns kundeapi.routes
  (:use compojure.core
        ring.adapter.jetty
        ring.middleware.reload
        ring.middleware.stacktrace
        ring.middleware.json-params
        ring.util.response
        ring.util.servlet
        ring.handler.dump
        kundeapi.db)
  (:require [compojure.route :as route]
            [clj-json.core :as json]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes handler
  (GET "/kunder/amsid/:id" [id]
    (json-response (find-kunder-for-ams-id id)))
  (GET "/abonnementer/kundeid/:id" [id]
    (json-response (find-abon-for-kunde-id (str " " id))))
  (PUT "/kunde" [attrs]
    (json-response (opret-kunde attrs)))
  (PUT "/kunde/:id" [id attrs]
    (json-response (opdater-kunde id attrs)))
  (DELETE "/kunde/:id" [id]
    (json-response (slet-kunde id)))
  (route/not-found "Page not found"))

(def app
     (-> (var handler)
         (wrap-reload '(kundeapi.db))
         (wrap-reload '(kundeapi.routes))
         (wrap-json-params)
         (wrap-stacktrace)))

(defn boot []
  (future (run-jetty #'app {:port 8080})))

(boot)
