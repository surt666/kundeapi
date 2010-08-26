(ns kundeapi.db
  (use clojure.contrib.sql))

(defn connection-props [connect-string user password]
  {:classname "oracle.jdbc.driver.OracleDriver"
   :subprotocol "oracle:thin"
   :subname (str "@" connect-string)
   :user user
   :password password })

(defn dev-db-props [user password]
  (connection-props "lisbon:1521:tctvspoc" user password))

(def db (dev-db-props "SPOC_DW" "SP_DW_TE3"))

(defn find-kunder-for-ams-id [id]
  (with-connection db
    (with-query-results rs ["select customerid, firstname, lastname, mail from customer_ams_address where addressid = ?" id]       
      (vec rs))))

(defn find-abon-for-kunde-id [id]
  (with-connection db
    (with-query-results rs ["select varenummer, varenavn from customerproduct where (ophxr = to_date('1900-01-01','YYYY-MM-DD') or ophxr = null or ophxr > sysdate) and modtager = ?" id]    
      (vec rs))))

(defn opret-kunde [attrs]
  attrs)

(defn opdater-kunde [id attrs]
  attrs)

(defn slet-kunde [id]
  true)