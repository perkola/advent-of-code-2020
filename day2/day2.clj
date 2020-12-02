(ns day2
  (:require [clojure.string :as str]))

(def lines (str/split (slurp "input") #"\n"))

(defn valid-password-1? [[x1 x2 c password]]
  (let [c (-> (re-pattern c)
            (re-seq password)
            (count))]
    (>= (read-string x2) c (read-string x1))))

(defn valid-password-2? [[x1 x2 c password]]
  (let [e1 (= (str (get password (dec (read-string x1)))) c)
        e2 (= (str (get password (dec (read-string x2)))) c)]
    (not= e1 e2)))

(defn solution [fn]
  (->> lines
    (map #(->> (re-matcher #"(\d+)-(\d+) ([a-z]): ([a-z]+)" %)
            (re-find)
            (rest)
            (into [])))
    (map fn)
    (filter identity)
    (count)))

(println (solution valid-password-1?))
(println (solution valid-password-2?))
