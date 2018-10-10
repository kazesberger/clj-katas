(ns foreclojure.4clj97)

( (defn triangle [n]
    (nth (iterate
           (fn [row]
             (vec (map + (cons 0 row) (conj row 0))))
           [1])
         (dec n)))
  2)
