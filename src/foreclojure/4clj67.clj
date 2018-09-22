(ns foreclojure.4clj67)

(defn testfn [__]
  (and
    (= (__ 2) [2 3])
    (= (__ 5) [2 3 5 7 11])
    (= (last (__ 100)) 541)))


(defn first-n-primes [n]
  (->> (take (dec n)
         (lazy-seq
           (filter  #(empty? (get % 1))
              (map (juxt
                     identity
                     (fn divisors [x]
                       (filter
                         #(= 0 (mod x %))
                         (range 2 (inc (#(Math/sqrt %) x))))))
                (drop 2 (range))))))
       (into {})
       (keys)
       (sort)
       (cons 2)))

(defn first-n-primes-2 [n]
  (->> (take (dec n)
         (remove #(some (fn divisor? [d]
                          (= 0 (mod % d)))
                        (range 2 (inc (Math/sqrt %))))
                  (drop 2 (range))))
       (cons 2)))

(comment
  (first-n-primes 5)
  (testfn first-n-primes-2)


  ((fn divisors [x]
     (filter
       #(= 0 (mod x %))
       (range 2 (inc (#(Math/sqrt %) 2)))))2)


  (take 10 (map #(range 2 (inc (Math/sqrt %))) (drop 2 (range))))

  (take 10 (iterate #(+ 2 %) 3))

  (keep next)
  (rem -100 90)
  (mod 80 90)


  (map #(Math/sqrt %) (range 2 101))



  prime === no #(= 0 (mod (range 2 (inc %))  (range 2 (inc (sqrt n)))))

  (range 2 3)

  (range 2 (inc (#(Math/sqrt %)10)))

  (filter #(= 0 (mod % 2)) (range 10))

  (def num-with-divisors '([2 (2)] [3 ()] [4 (2)] [5 ()] [6 (2 3)] [7 ()] [8 (2)] [9 (3)] [10 (2)]))
  (map #(get % 1) num-with-divisors))