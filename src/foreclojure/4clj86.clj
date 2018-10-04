(ns foreclojure.4clj86)

; num -> digits -> map square -> reduce + -> repeat until 1

;(defn num->digits
;  ([num] (num->digits [] num))
;  ([acc num]
;   (if (< num 10)
;     (cons num acc)
;     (recur (cons (mod num 10) acc) (quot num 10)))))
;
;(def digit-sum
;  (memoize
;    (fn [x]
;      (letfn [(num->digits
;                ([num] (num->digits [] num))
;                ([acc num]
;                 (if (< num 10)
;                    (cons num acc)
;                    (recur (cons (mod num 10) acc) (quot num 10)))))]
;        (apply + (map #(* % %) (num->digits x)))))))

;(
;  (defn happy? [x]
;    (letfn [(num->digits
;              ([num] (num->digits [] num))
;              ([acc num]
;               (if (< num 10)
;                 (cons num acc)
;                 (recur (cons (mod num 10) acc) (quot num 10)))))]
;        (let [digit-sum (apply + (map #(* % %) (num->digits x)))]
;          (if (= 1 digit-sum)
;            true
;            ;(recur digit-sum))))) 7)
;            digit-sum)))))

;((memoize happy?) 986543210)

;(letfn [(unhappy? [set sum]
;          (if (and (= (count set) (count (conj set sum)))
;                   (not= 1 sum))))])

(defn hap?
  ([sum] (hap? #{} sum))
  ([acc sum]
   (letfn [(digit-sum [x]
              (letfn [(num->digits
                        ([num] (num->digits [] num))
                        ([acc num]
                         (if (< num 10)
                           (cons num acc)
                           (recur (cons (mod num 10) acc) (quot num 10)))))]
                (apply + (map #(* % %) (num->digits x)))))]
      (let [it-sum (digit-sum sum)]

        (cond
          (= 1 it-sum) true
          (acc it-sum) false
          ;:else it-sum)))))
          :else (recur (conj acc it-sum) it-sum))))))
zipmap

(hap? 7)
(if (#{1 2 3}5) true false)

((fn [set sum]
   (letfn [(digit-sum [x]
             (letfn [(num->digits
                       ([num] (num->digits [] num))
                       ([acc num]
                        (if (< num 10)
                          (cons num acc)
                          (recur (cons (mod num 10) acc) (quot num 10)))))]
               (apply + (map #(* % %) (num->digits x)))))]
     (let [it-sum (digit-sum sum)
           it-set (conj set it-sum)]

       (cond
         (= 1 it-sum) true
         (= (count set) (count it-set)) false
         :else (recur it-set it-sum)))))
      ;it-sum)))
 #{} 7)

(comment
  (take)
  (apply distinct? 5 [1 2 3])
  ( (iterate (memoize digit-sum) 2))
  (take 10 (iterate (memoize happy?) 3))
  (= (int 1.0) 1)
  (quot 123 10))