(ns foreclojure.4clj103)

( (defn k-comb [k n-set]
    (loop [k n-set]
      (if (= k (count n-set))
        n-set
        (flatten
          (for [n n-set]
            (recur k (disj n-set n)))))))
  2 #{0 1 2 3})


( (defn comb [k n-set]
     (take 2
           (iterate (fn [combs]
                      (map #(disj combs %) combs)) (seq n-set))))
  2 #{0 1 2 3})


( (fn [k n-set]
    (if (<= 0 (- (count n-set) k))
      (set (nth
             (iterate
               (fn [combs]
                 (flatten (map
                            (fn [x] (map #(disj x %) x))
                            combs))) [n-set])
             (- (count n-set) k)))
      #{}))
 ;10 #{4 5 6}
 4 #{[1 2 3] :a "abc" "efg"})

( (fn combinations [k s]
    (cond
      (zero? k) #{#{}}
      (empty? s) #{}
      :else (set (clojure.set/union
                   (map #(conj % (first s)) (combinations (dec k) (rest s)))
                   (combinations k (rest s))))))
  2 #{0 1 2 3})
