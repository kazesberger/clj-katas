(ns foreclojure.4clj96)

(defn samplefn [__]
  [
   (__ '(:a (:b nil nil) nil))
   (__ '(:a (:b nil nil) (:c nil nil)))
   (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])])

(samplefn (fn [[_ & children]] (apply = children)))
(samplefn symm?)

( (defn symm? [[_ a b]]
    (letfn
      [(mn? [a b]
         (println a b)
         (cond
           (every? nil? [a b]) true
           (and
            (every? coll? [a b])
            (apply = (map first [a b]))
            (every? true?
              (map mn?
                 (first (map rest [a b]))
                 (reverse (second (map rest [a b])))))) true
           :else false))]
          ;(map #(apply mn? %)
          ;     [[(first a) (second b)]
          ;      [(first b) (second a)]])))]
      (mn? a b)))

  [1 [2
      nil
      [3 nil nil]]
     [2
      [3 nil nil]
      nil]])

; lol i did this waaaayyyyy too complicated. just mirror the tree and (apply = children) done.

(comment
  (def sample [[2 nil [3 nil nil]] [2 [3 nil nil] nil]])
  (map println (first (map rest sample)) (reverse (second (map rest sample))))
  (map #(apply conj %) [[[1 2] 3]
                        [[4 5] 6]]))