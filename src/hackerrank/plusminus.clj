(ns hackerrank.plusminus)

(def arr [2 2 -1 -1 -1 0])

(println
  (clojure.string/join \newline
    (map #(format "%.6f" (double %))

      ((juxt #(/ (count (filter pos? %)) (count arr))
             #(/ (count (filter neg? %)) (count arr))
             #(/ (count (filter zero? %)) (count arr)))
       arr))))

(format "%.6f" (double 1/3))

