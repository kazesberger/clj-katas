(ns foreclojure.4clj69)

(defn testfn [__]
  (and
    (= (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
       {:a 4, :b 6, :c 20})
    (= (__ - {1 10, 2 20} {1 3, 2 10, 3 15})
       {1 7, 2 10, 3 15})
    (= (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
       {:a [3 4 5], :b [6 7], :c [8 9]})))

(defn m-w [f & maps]
  (into {}
        (for [key (set (flatten (map keys maps)))]
          [key   (apply
                   (fn ([x] x)
                     ([x & ys] (apply f x ys)))
                   (keep #(get % key) maps))])))

(comment

  (defn m-w [f & maps]
    (let [ks (set (flatten (map keys maps)))]
      ks))

  (filter #(> (count (val %)) 1) {:a [2 2] :b [3 2] :c [4 5]})
  (= {:a [2 2] :b [3 2] :c [4]}
    (merge
      (filter #(> (count (val %)) 1) {:a [2 2] :b [3 2] :c [4]})
      (remove #(> (count (val %)) 1) {:a [2 2] :b [3 2] :c [4]})))

  (conj {:a 1} [:a nil])
  (reduce #(conj (or %1 {}) %2) '({:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5}))



  (for [key (set (flatten (map keys maps)))]
    ;(println key))
    [key (keep #(get % key) maps)])

  (let [f -]
    ((fn ([x] x)
      ([x & ys] (apply f x ys))) 5 10))

  (defn m-w [f & maps]
    (into {}
      (for [key (set (flatten (map keys maps)))]
        [key   (apply
                 (fn ([x] x)
                     ([x & ys] (apply f x ys)))
                (keep #(get % key) maps))])))


  (map #(get % :a) maps)

  (get :a (first maps))
  (get :a  {:a 2, :b 3, :c 4})

  (testfn m-w)
  (testfn merge-with))

(comment
  (def maps '({:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5} {:a 4, :b 6, :c 20 :d 10}))
  (- 15)
  (concat [8 9])
  (m-w {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
  (m-w {1 10, 2 20} {1 3, 2 10, 3 15})
  (m-w {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]}))
