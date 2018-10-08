(ns foreclojure.4clj91)


(defn testfn [foo]
  (and
    (= true (foo #{[:a :a]}))
    (= true (foo #{[:a :b]}))
    (= false (foo #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4]}))
    (= true (foo #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4] [3 4]}))
    (= false (foo #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e]}))
    (= true (foo #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e] [:x :a]}))))

(defn samplefn [__]
  [
   (__ #{[:a :a]})
   (__ #{[:a :b]})
   (__ #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4]})
   (__ #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4] [3 4]})
   (__ #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e]})
   (__ #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e] [:x :a]})])

(testfn connected?)

((defn connected?
  ([edges]
   (connected? (disj edges (first edges)) #{(first edges)}))

  ([tobeconnected-edges connected-edges]
   (let [connected-nodes (reduce into #{} connected-edges)
         edges-with-path (filter #(seq (filter connected-nodes %)) tobeconnected-edges)
         remaining-edges (reduce disj tobeconnected-edges edges-with-path)]
     (cond
       (empty? remaining-edges) true
       (empty? edges-with-path) false
       :else (connected? remaining-edges (into connected-edges edges-with-path))))))

 #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4] [3 4]})


(comment
  (cont)
  (def edges-with-path (filter #(seq (filter #{3 2} %)) tobeconnected-edges))
  (def tobeconnected-edges #{[3 4] [6 4] [5 6] [4 5] [3 1] [1 2]})
  (def connected-edges #{[2 3]})
  (def connected-nodes (reduce into #{} connected-edges))
  (filter #(filter #{1 2} %) #{[1 3] [3 4 ] [5 6] [2 5]})
  (flatten (seq #{[1 2] [3]}))
  (reduce into #{} #{[1 2] [3 3] [3 4]})
  (samplefn println))



;#{[1 2]}                            tuples #{[2 3] ..}
;
;#{1 2}                          (filter #{1 2} tuples)

(comment)
