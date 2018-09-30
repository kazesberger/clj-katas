(ns hackerrank.staircase)

(def n 6)

(map println
  (rest
     (reverse
       (for [i (range 0 (inc n))]
         (apply str(concat (repeat i \space) (repeat (- n i) \#)))))))