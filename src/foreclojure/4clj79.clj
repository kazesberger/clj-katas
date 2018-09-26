(ns foreclojure.4clj79)

(defn testfn [__]
  (and
    (= 7 (__ '([1]
               [2 4]
               [5 1 4]
               [2 3 4 5]))) ; 1->2->1->3

    (= 20 (__ '([3]
                [2 4]
                [1 9 3]
                [9 9 2 4]
                [4 6 6 7 8]
                [5 7 3 5 1 4]))))) ; 3->4->3->2->7->1

(defn samplefn [__]
  [
   (__ '( [1]
          [2 4]
          [5 1 4]
          [2 3 4 5])) ; 1->2->1->3
   (__ '([3
          [2 4]
          [1 9 3]
          [9 9 2 4]
          [4 6 6 7 8]
          [5 7 3 5 1 4]]))])

((fn graph [acc vs i]
  (if (seq vs)
    (let [left [i (get (first vs) i)]
          right [(inc i) (get (first vs) (inc i))]
          left-or-right [left right]
          x  (apply min (remove nil? (map second left-or-right)))
          foo (filter #(= x (second %)) left-or-right)
          next-i (get (first foo) 0)]
      (println left-or-right x foo next-i)
      (recur (conj acc x) (rest vs) next-i))
    (apply + acc)))
      ;[left-or-right x next-i])))
 [] '( [1]
       [2 4]
       [5 1 4]
       [2 3 4 5])
     0)

(comment
  (def left-or-right [[0 1] [1 nil]])
  (def left-or-right [[0 5] [1 1]])
  (def x 1)
  (get-in '([0 1]) [0 0])
  (samplefn #(graph [] % 0))
  (testfn #(graph [] % 0))
  (def i 0)
  (def acc [])
  (def vs '([3]
            [2 4]
            [1 9 3]
            [9 9 2 4]
            [4 6 6 7 8]
            [5 7 3 5 1 4]))
  (min 1 nil))