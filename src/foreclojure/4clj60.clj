(ns foreclojure.4clj60)


;(defn my-reductions
;  ([f coll] (my-reductions f (first coll) (rest coll)))
;  ([f init coll]
;   (loop [result []
;          val init
;          rest-coll coll]
;     (println result val rest-coll)
;     (if (empty? rest-coll)
;       result
;       (let [reduction (conj result (f val (first rest-coll)))]
;         (recur  (conj result reduction) reduction (rest rest-coll)))))))
(defn my-reductions
  ([f coll] (my-reductions f (first coll) (rest coll)))
  ([f init [head & tail :as coll]]
   (cons init
     (lazy-seq
       (if (seq coll)
           (my-reductions f (f init head) tail))))))

(take 5 (my-reductions + (range)))

;(let [foo "foo" bar "bar"]
;  (loop [s (str foo bar)]
;    (when (> (count s) 0)
;      (println foo bar s)
;      (recur (apply str (rest s))))))
;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;
;(fn my-reductions
;  ([f coll] (my-reductions f (first coll) (rest coll)))
;  ([f x coll]
;   (println x coll)
;   (fn [acc])))
;
;(juxt)