(ns foreclojure.4clj95)

(
  (fn btree? [node]
      (or
        (nil? node)
        (and
          (coll? node)
          (= (count node) 3)
          (every? true? (map btree? (rest node))))))
 '(:a (:b nil nil) nil))



(comment
  (nil? (nth '(:b nil) 2))
  (and true true false)
  (coll? nil)
  (nth '(1 2) 1)
  (count))