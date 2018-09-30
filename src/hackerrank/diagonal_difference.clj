(ns hackerrank.diagonal-difference)

(for [i (range 3)
      j (reverse (range 3))]
  (println [i j]))

(map vector (range 3) (reverse (range 3)))

([0 1 2] 2)

(Math/abs
  (-
    (apply + (map #(get-in arr %) (for [i (range (count (arr 0)))]
                                    [i i])))
    (apply + (map #(get-in arr %) (map vector (range (count (arr 0))) (reverse (range (count (arr 0)))))))))