(ns day5
  (:require [clojure.string :as str]))

(def lines (str/split (slurp "input") #"\n"))

(defn column [b l]
  (if (<= (count l) 0)
    (first b)
    (column ((if (= (first l) "L") take drop) (/ (count b) 2) b) (rest l))))

(defn seat-id [b l]
  (if (= (count l) 3)
    (-> (first b)
        (* 8)
        (+ (column (range 0 8) l)))
    (seat-id ((if (= (first l) "F") take drop) (/ (count b) 2) b) (rest l))))

(defn day5-1 []
  (->>
    lines
    (map #(seat-id (range 0 128) (str/split % #"")))
    (sort)
    (last)))

(println (day5-1))

(defn day5-2 []
  (->>
    lines
    (map #(seat-id (range 0 128) (str/split % #"")))
    (sort)
    (partition 2 1)
    (filter #(not= 1 (- (second %) (first %))))
    (first)
    (first)
    (inc)))

(println (day5-2))
