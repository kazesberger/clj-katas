(ns foreclojure.4clj66)


(defn testfn [__]
  (and
    (= (__ 2 4) 2)
    (= (__ 10 5) 5)
    (= (__ 5 7) 1)
    (= (__ 1023 858) 33)))

; https://en.wikipedia.org/wiki/Euclidean_algorithm

(defn gcd [x y]
  (if (zero? y)
    x
    (recur y (mod x y))))

(testfn gcd)