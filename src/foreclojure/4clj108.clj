(ns foreclojure.4clj108)

(defn testfn [__]
  (and
    (= 3 (__ [3 4 5]))
    (= 4 (__ [1 2 3 4 5 6 7] [0.5 3/2 4 19]))
    (= 7 (__ (range) (range 0 100 7/6) [2 3 5 7 11 13]))
    (= 64 (__ (map #(* % % %) (range)) ;; perfect cubes
              (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
              (iterate inc 20))))) ;; at least as large as 20

( (defn lazy-searching [& seqs]
    (let [firsts (map first seqs)
          candidate (apply max firsts)]
      (if (apply = firsts)
        candidate
        (recur (map (fn [x] (drop-while #(> candidate %) x)) seqs)))))
  (take 15 (map #(* % % %) (range))) ;; perfect cubes
  (take 15 (filter #(zero? (bit-and % (dec %))) (range))) ;; powers of 2
  (take 150 (iterate inc 20)))
  ;[1 2 3 4 6 8]
  ;(range)
  ;[5 7 8])

(testfn lazy-searching)

((comp first #(drop-while (fn [x] (>= 10 x)) %)) (take 15 (filter #(zero? (bit-and % (dec %))) (range))))
(some nil? [1 1 3])
(apply (fnil max [nil 1 3]))
(first (drop-while (fn [x] true) [1 2 3]))
( (fn foo [& xs] (every? #(some #{1} %) xs)) [1 2 3] [0 2 1])
( (fn foo [& xs] (apply max (map first xs))) [1 2 3] [0 2 1])
( (fn foo [& xs] (map #(drop-while (fn [x] (> 1 x)) %) xs)) [1 2 3] [0 2 1])

(comment
  (first (drop-while #(> 5 %) (range)))
  (if (some #{1} (max (map (comp first sort)  [[3 2 1 0 9 42] [1  3]])))
    (println "true")
    (println "false"))
  (every? #(some #{1} %) [[0 1] [1 2]])
  (#(some #{1} %) [0 1]))