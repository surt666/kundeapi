(ns kundeapi.servlet
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:require [compojure.route :as route])
  (:use ring.util.servlet [kundeapi.routes :only [app]]))

(defservice app)