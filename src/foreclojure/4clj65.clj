(ns foreclojure.4clj65)

(defn testfn [__]
  (= [:map :set :vector :list] (map __ [{} #{} [] ()])))

(defn poke [t]
      (cond
        (= (get (conj t [:foo "bar"]) :foo) "bar") :map
        (= (count (conj t 42)) (count (conj (conj t 42) 42))) :set
        ;dont like my checks for vector/list atm...
        (= 43 (last (conj (conj t 42) 43))) :vector
        (= 43 (first (conj (conj t 42) 43))) :list
        :else :unknown-type))

(testfn poke)


(comment
  (conj '(1 2 3) 4)
  (last (conj #{1 2 4} 3))

  (map #(conj % 8) (map #(conj % 9) [#{} [] ()]))

  (map poke [{} #{43} [43] '(43)])
  (map #(filter nil? % [{} #{43} [43] '(43)]))

  (def t1 #{42})
  (count t1) (count (conj t1 42))

  (flatten (first {:a 1 :b 2}))

  (get (conj '() [:t \t]) :t))