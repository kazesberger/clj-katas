(ns foreclojure.4clj89-2nd)

(defn testfn [__]
  (and
    (= true (__ [[:a :b]]))
    (= false (__ [[:a :a] [:b :b]]))
    (= false (__ [[:a :b] [:a :b] [:a :c] [:c :a] [:a :d] [:b :d] [:c :d]]))
    (= true (__ [[1 2] [2 3] [3 4] [4 1]]))
    (= true (__ [[:a :b] [:a :c] [:c :b] [:a :e]
                 [:b :e] [:a :d] [:b :d] [:c :e]
                 [:d :e] [:c :f] [:d :f]]))
    (= false (__ [[1 2] [2 3] [2 4] [2 5]]))))

(defn samplefn [__]
  [
   (__ [[:a :b]])
   (__ [[:a :a] [:b :b]])
   (__ [[:a :b] [:a :b] [:a :c] [:c :a] [:a :d] [:b :d] [:c :d]])
   (__ [[1 2] [2 3] [3 4] [4 1]])
   (__ [[:a :b] [:a :c] [:c :b] [:a :e]
                [:b :e] [:a :d] [:b :d] [:c :e]
                [:d :e] [:c :f] [:d :f]])
   (__ [[1 2] [2 3] [2 4] [2 5]])])

(d)

((defn tour?
  ([edges]
   (if (= 1 (count edges)) ; make this end condition for 2-arity part?
     true
     (boolean
       (some #(tour? edges %) (set (flatten edges))))))
  ([remaining-edges current-node]
   (println remaining-edges current-node)
   (if (empty? remaining-edges)
     true
     (let [connecting-edges (filter #(seq (filter #{current-node} %)) remaining-edges)]
       (println "matching edges: " connecting-edges)
       (let [remove-one-occurance
              (fn [coll x]
                (let [[n m] (split-with (partial not= x) coll)]
                  (concat n (rest m))))]
         (some (fn [connecting-edge]
                 (tour? (remove-one-occurance remaining-edges connecting-edge)
                        (first (remove #{current-node} connecting-edge)))
                 #_(tour? (remove #{connecting-edge (vec (reverse connecting-edge))} remaining-edges)
                        (first (remove #{current-node} connecting-edge))))
               connecting-edges))))))
 ;[[:a :b] [:b :a] [:a :c]])
 [[:a :b] [:a :b] [:a :c] [:c :a] [:a :d] [:b :d] [:c :d]])
 ;[[1 2] [2 3] [3 4] [4 1]])
 ;[[:b :a] [:a :b] [:a :c] [:c :a] [:a :d] [:b :d] [:c :d]])
 ;[[:a :a] [:b :b]])

(testfn tour?)
(samplefn tour?)

(comment
  (let [[n m] (split-with (partial not= x) coll)]
    (concat n (rest m)))
  (boolean nil)
  (first (remove #{:b} [:a :b]))
  (tour?)
  (samplefn println))