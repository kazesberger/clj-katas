(ns foreclojure.4clj92)

(defn testfn [__]
  (and
    (= 14 (__ "XIV"))
    (= 827 (__ "DCCCXXVII"))
    (= 3999 (__ "MMMCMXCIX"))
    (= 48 (__ "XLVIII"))))

(defn samplefn [__]
  [
    (__ "XIV")
    (__ "DCCCXXVII")
    (__ "MMMCMXCIX")
    (__ "XLVIII")])

(def r-numerals {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000})

((defn decode [roman]
   (->> roman
        (map {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000})
        ;(partition-by identity)))
        ;(map #(apply + %))))
        (reduce (fn [[acc-sum [:as parts] :as num] x]
                  (println num acc-sum parts x)
                  (cond
                    (or
                      (empty? parts)
                      (= x (last parts))) [acc-sum (conj parts x)]
                    (< x (last parts)) [(apply + acc-sum parts) [x]]
                    (> x (last parts)) [(+ acc-sum (- x (apply + parts))) []]))
                [0 []])
        (flatten)
        (apply +)))

 "MMMCMXCIX")
 ;"XIV")

(comment
  (samplefn decode)
  (testfn decode)
  (def sample '(1000 1000 1000 100 1000 10 100 1 10 5))
  (def sample '(3000 100))
  (reduce (fn [[acc-sum [:as parts] :as num] x]
            (println num acc-sum parts x)
            (cond
              (or (empty? parts)
                  (<= x (last parts))) [acc-sum [x]]
              (< (last parts) x) [(+ acc-sum (- x (apply + parts)))]))
          [0 []]
          sample)
  (map #(partition-by identity %) (samplefn (partial map r-numerals)))
  (samplefn println))