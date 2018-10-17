(ns foreclojure.4clj106)

;(fn maze [x y]
;  (println x y)
;  (cond
;    (and (x odd?) (y even?)) (recur (* x 2) y)
;    (and (y odd?) (x even?)) (recur (/ x 2) y)
;    (and (y odd?) (< x y)) (recur (+ x 2))
;    (and (y even?) (< x y))) (recur (* x 2))
;    (and y even? ()))



;( (fn maze
;    ([x y] (if (= x y) 1 (maze x y 1)))
;
;    ([x y counter]
;     (if (nil? (some #(= y %) [(* x 2)
;                               (/ x 2)
;                               (+ x 2)]))
;
;         (min (for [f [#(* 2 %) #(/ % 2) #(+ % 2)]]
;                (maze (f x) y (inc counter))))
;         counter)))
;  3 12)

; above attempt failed bc it doesnt terminate once the first most shallow solution was found. face -> palm


((fn next-level [x] (filter int? (map #(% x) [#(* % 2) #(/ % 2) #(+ % 2)]))) 3)

( (fn maze
    ([x y]
     (if (= x y)
       1
       (let [next-level (fn [x]
                          (filter int? (map #(% x) [#(* % 2) #(/ % 2) #(+ % 2)])))]
         (loop [leaves (next-level x)
                counter 2]
           (if (some #{y} leaves)
             counter
             (recur (flatten (map next-level leaves)) (inc counter))))))))
  9 12)