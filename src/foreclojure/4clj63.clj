(ns foreclojure.4clj63)

(defn testfn [__]
  (and
    (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
    (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]]) {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
    (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]]) {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})))

; { r1 [c1 c2]  r2 [c3 c4]}
; [r1 r2] -> ez
; fn [r] -> values
; update-in conj

;(update-in {} [(f)]
;            #(conj (vec %1) inc %2))))

(defn gb [f coll]
  (reduce
    (fn [m x] (update m (f x) #(conj (vec %) x)))
    {}
    coll))

(testfn group-by)
(testfn gb)

(update {} (#(> % 5) 1) (fn [results] (conj (vec results) 1)))
(update {false [1]} (#(> % 5) 3) (fn [results] (conj (vec results) 3)))
(update {false [1 3]} (#(> % 5) 6) (fn [results] (conj (vec results) 6)))
(update {false [1 3], true [6]} (#(> % 5) 6) (fn [results] (conj (vec results) 8)))