(ns foreclojure.4clj101)

(defn testfn [__]
  (and
    (= (__ "kitten" "sitting") 3)
    (= (__ "closure" "clojure") (__ "clojure" "closure") 1)
    (= (__ "xyx" "xyyyx") 2)
    (= (__ "" "123456") 6)
    (= (__ "Clojure" "Clojure") (__ "" "") (__ [] []) 0)
    (= (__ [1 2 3 4] [0 2 3 4 5]) 2)
    (= (__ '(:a :b :c :d) '(:a :d)) 2)
    (= (__ "ttttattttctg" "tcaaccctaccat") 10)
    (= (__ "gaattctaatctc" "caaacaaaaaattt") 9)))

(defn samplefn [__]
  [
   (__ "kitten" "sitting")
   [(__ "closure" "clojure") (__ "clojure" "closure")]
   (__ "xyx" "xyyyx")
   (__ "" "123456")
   [(__ "Clojure" "Clojure") (__ "" "") (__ [] [])]
   (__ [1 2 3 4] [0 2 3 4 5])
   (__ '(:a :b :c :d) '(:a :d))
   (__ "ttttattttctg" "tcaaccctaccat")
   (__ "gaattctaatctc" "caaacaaaaaattt")])

( (defn lev-recur [s1 s2]
    (let [recur-fn (fn [fun s t]
                     (cond
                       (empty? s) (count t)
                       (empty? t) (count s)
                       (apply = (map last [s t])) (fun fun (butlast s) (butlast t))
                       :else (inc (min
                                    (fun fun (butlast s) t)
                                    (fun fun s (butlast t))
                                    (fun fun (butlast s) (butlast t))))))
          mfn (memoize recur-fn)]
      (mfn mfn s1 s2)))
  "ttttattttctg" "tcaaccctaccat")
  ;"kitten" "sitting")

(comment

  (let [foo (memoize #(range %))]
    (foo 3))
  (samplefn lev-recur)
  (samplefn lev)
  (empty? "")
  (butlast nil)
  (apply = (map  last ["asdf" "qwer"])))