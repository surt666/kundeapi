(ns kundeapi.test.db
  (:use kundeapi.db
        clojure.test :reload-all))

(deftest find_kunder_for_ams_id_test
  (is (= (:customerid (first (find_kunder_for_ams_id 7426884)))  "600046035")))

(deftest find_abon_for_kunde_id_test
  (is (= (:varenummer (first (find_abon_for_kunde_id 600046035)))  "1301121")))
