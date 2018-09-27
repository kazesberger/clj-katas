(ns foreclojure.4clj81)


(= (keep #{0 1 2 3} #{2 3 4 5}) #{2 3})

(clojure.set/intersection)

((defn inters [s1 & ss]
  (set (filter (fn [elem] (every? #(% elem) ss)) s1)))
 #{:a :b :c}     #{:b :c :d} #{:c :e :d})

((comp set filter)#{:a :b :c}     #{:b :c :d} #{:c :e :d})

(filter #{:a :b :c} #{:d :b :c})
(set)


((fn foo [a & xs]
   (map inc xs)) 1 2 3)
(every? #(% 4) [#{1 2 3} #{2 3 4}])

(map inc [2 3])
(#{:a :b :c} :a)