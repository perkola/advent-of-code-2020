(ns day4
  (:require [clojure.string :as str]))

(def lines (str/split (slurp "input") #"\n\n"))

(defn solution []
(->> lines
     (filter #(->> (re-matcher #"byr:(200[0-2]|19[2-9][0-9])\b" %) (re-find)))
     (filter #(->> (re-matcher #"iyr:(201[0-9]|2020)\b" %) (re-find)))
     (filter #(->> (re-matcher #"eyr:(202[0-9]|2030)\b" %) (re-find)))
     (filter #(->> (re-matcher #"hgt:(1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in)\b" %) (re-find)))
     (filter #(->> (re-matcher #"hcl:\#[0-9a-f]{6}\b" %) (re-find)))
     (filter #(->> (re-matcher #"ecl:(amb|blu|brn|gry|grn|hzl|oth)\b" %) (re-find)))
     (filter #(->> (re-matcher #"pid:[\d]{9}\b" %) (re-find)))
     (count)))

(println (solution))