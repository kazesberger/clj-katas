(ns foreclojure.4clj100
  (:require [clojure.math.numeric-tower :as math]))

(defn samplefn [__]
  [
   (__ 2 3)
   (__ 5 3 7)
   (__ 1/3 2/5)
   (__ 3/4 1/6)
   (__ 7 5/7 2 3/5)])

(defn gcd [x y]
  (if (zero? y)
    x
    (recur y (mod x y))))

( (defn lcm [& xs]
    (letfn [(gcd [x y]
              (if (zero? y)
                x
                (recur y (mod x y))))]
      (reduce #(/ (* %1 %2) (gcd %1 %2)) xs)))
  4 6)

(samplefn lcm)