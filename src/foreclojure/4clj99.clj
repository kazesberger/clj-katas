(ns foreclojure.4clj99)

( (fn pro-digits [x y]
    (->> (* x y)
         (str)
         (seq)
         (map str)
         (map #(Integer/parseInt %))))



  99 9)

(map Integer/parseInt ["99" "1"])