(ns day1
  (:require [clojure.string :as str]))

(def lines (into [] (map read-string (str/split (slurp "input") #"\n"))))

(println (first (filter some? (for [x1 lines x2 lines] (if (= (+ x1 x2) 2020) (* x1 x2))))))

(println (first (filter some? (for [x1 lines x2 lines x3 lines] (if (= (+ x1 x2 x3) 2020) (* x1 x2 x3) nil)))))
