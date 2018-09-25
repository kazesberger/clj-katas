(ns foreclojure.4clj75)


(defn testfn [__]
  (and
    (= (__ 1) 1)
    (= (__ 10) (count '(1 3 7 9)) 4)
    (= (__ 40) 16)
    (= (__ 99) 60)))
(defn samplefn [__]
  [(__ 1)
   (__ 10)
   (__ 40)
   (__ 99)])

(comment
  (defn totfn [num]
    ((fn divisors [x]
      (filter
        #(zero? (mod x %))
        (range 2 x)))num)))

(defn totfn [x]
      (let [divs-of-x (filter
                        #(zero? (mod x %))
                        (range 2 x))]
    ;(count
    ;  (cons 1
    ;    (remove nil?
          (for [candidate (range 1 x)
                div-of-cand  (filter
                                  #(zero? (mod candidate %))
                                  (range 2 candidate))]
          ;[div-of-cand candidate])))
             (when (some #{div-of-cand} divs-of-x) [div-of-cand candidate]))))
    ;(filter #((and
    ;                (> (mod % divisor) 0)
    ;                (> (mod x %) 0)))
    ;         (range 2 x))))

(defn phi [x]
  (letfn [(primes [num] (filter
                          #(zero? (mod num %))
                          (cons 2 (remove #(some (fn divisor? [d]
                                                  (= 0 (mod % d)))
                                                 (range 2 (inc (Math/sqrt %))))
                                       (drop 2 (range))))))]
    (primes x)))

(defn primes []
      (cons 2 (remove #(some (fn divisor? [d]
                               (= 0 (mod % d)))
                             (range 2 (inc (Math/sqrt %))))
                   (drop 2 (range)))))

(def num 1)
((fn phi [num]
   (apply * num (map #(- 1 (/ 1 %))
                     (filter
                       #(zero? (mod num %))
                       (take num (cons 2 (remove #(some (fn divisor? [d]
                                                          (= 0 (mod % d)))
                                                        (range 2 (inc (Math/sqrt %))))
                                                 (drop 2 (range)))))))))
 10)

  ;(* n #()))

(comment
  (take 10 (phi 10))
  (type (/ 14 3))
  (range 2 10)
  (totfn 12)
  (samplefn totfn)
  (letfn
    [(foo [x y] #(bar (conj x y) y))
     (bar [x y] (if (> (last x) 10)
                  x
                  #(foo x (+ 2 y))))]))