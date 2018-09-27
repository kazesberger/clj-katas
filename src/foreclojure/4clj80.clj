(ns foreclojure.4clj80)

(defn testfn [__]
  (and
    (= (__ 6) true)
    (= (__ 7) false)
    (= (__ 496) true)
    (= (__ 500) false)
    (= (__ 8128) true)))

(defn samplefn [__]
  [
    (__ 6)
    (__ 7)
    (__ 496)
    (__ 500)
    (__ 8128)])

(testfn perfect-num?)
(samplefn perfect-num?)
(samplefn sum-div)
(samplefn #(= % (sum-div %)))

(defn sum-div [num]
  (apply +
              ((fn divisors [x]
                 (cons 1
                       (set
                         (reduce #(conj %1 %2 (/ x %2)) []
                                 (filter
                                   #(= 0 (mod x %))
                                   (range 2 (inc (#(Math/sqrt %) x))))))))num)))

((defn perfect-num? [num]
   (= num (apply +
               ((fn divisors [x]
                  (cons 1
                        (set
                          (reduce #(conj %1 %2 (/ x %2)) []
                                  (filter
                                    #(= 0 (mod x %))
                                    (range 2 (inc (#(Math/sqrt %) x))))))))num))))6)


(comment
  (apply +
    ((fn divisors [x]
       (cons 1
         (set
           (reduce #(conj %1 %2 (/ x %2)) []
             (filter
               #(= 0 (mod x %))
               (range 2 (inc (#(Math/sqrt %) x)))))))496)))
  (def x 496)
  (+ 2 4 8 16)
  (/ 496 62)
  (Math/sqrt 496)
  (/ 496 31))