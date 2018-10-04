(ns foreclojure.4clj93)

(defn testfn [__]
  (and
    (= (__ [["Do"] ["Nothing"]])
       [["Do"] ["Nothing"]])

    (= (__ [[[[:a :b]]] [[:c :d]] [:e :f]])
       [[:a :b] [:c :d] [:e :f]])

    (= (__ '((1 2)((3 4)((((5 6)))))))
       '((1 2)(3 4)(5 6)))))

((defn pf [coll]
  (if (every? coll? coll)
    (mapcat pf coll)
    [coll]))
 [[[[:a :b]]] [[:c :d]] [:e :f]])

(testfn pf)
(comment
  (coll? "asdf")
  (reduce conj [] [["Do"] ["Nothing"]])
  (reduce #(if (every? coll? %2) (apply conj %1 %2) (conj %1 %2)) [] [[[[:a :b]]] [[:c :d]] [:e :f]]))