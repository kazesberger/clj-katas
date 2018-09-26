(ns foreclojure.4clj78)

(defn testfn [__]
  (and

    (= (letfn [(triple [x] #(sub-two (* 3 x)))
               (sub-two [x] #(stop?(- x 2)))
               (stop? [x] (if (> x 50) x #(triple x)))]
         (__ triple 2))
       82)
    (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
               (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
         (map (partial __ my-even?) (range 6)))
       [true false true false true false])))

(defn samplefn [__]
  [
    (letfn [(triple [x] #(sub-two (* 3 x)))
            (sub-two [x] #(stop?(- x 2)))
            (stop? [x] (if (> x 50) x #(triple x)))]
         (__ triple 2))
    (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
            (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
         (map (partial __ my-even?) (range 6)))])

(testfn tramp)
(samplefn tramp)

(defn tramp [f & xs]
  (loop [result (apply f xs)]
    (if (fn? result) (recur (result)) result)))

(comment
  (type #(map)))