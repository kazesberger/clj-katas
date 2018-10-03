(ns foreclojure.4clj85)


((fn power-set [zet]
  (set
    ((fn meh [x]
       (println x)
       (if (seq x)
         (flatten (for [y x]
                    [x (meh (disj x y))]))
         '(#{})))
     zet)))
 ;#{1 2 3})
 #{})


((fn ps [x]
  (map #((comp set concat)(ps %) %) (set (map #(disj x %) x))))
 #{1 2 3})

; disj k elements from set (up to count set)

((fn ps [argset]
  (into #{}
    (
      (fn foo [x]
         (flatten
            (if (seq x)
              (let [asdf (map #(disj x %) x)]
                (println x asdf)
                (concat [x] asdf (map foo asdf)))
              '())))
      argset)))
 #{})

((fn [s]
  (reduce
    #(into %
           (for [accset-it %]
             (conj accset-it %2)))
    #{#{}} s))
 ;#{}
 #{1 2 3})

(comment
  (conj #{} 1)
  (concat #{1 3 2} '(#{3 2} #{1 2} #{1 3}))
  (set '(#{}))
  (nil? (first #{1 2 3}))
  (disj #{:a } :a)
  (for [foo #{}]
    (println foo))
  (peek #{:a :b :c})
  (first #{:a :b :c})
  (def foo #{:a :b :c})
  (for [bar foo] (disj foo bar))
  (disj #{ 2 3 1}))