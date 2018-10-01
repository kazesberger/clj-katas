(ns foreclojure.4clj84)

(defn testfn [__]
  (and
    (let [divides #{[8 4] [9 3] [4 2] [27 9]}]
      (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))
    (let [more-legs
          #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
      (= (__ more-legs)
         #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
           ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))
    (let [progeny
          #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
      (= (__ progeny)
         #{["father" "son"] ["father" "grandson"]
           ["uncle" "cousin"] ["son" "grandson"]}))))

((defn rels [pairset]
   (let [trans (for [[key val] pairset
                     [valkey valval] pairset
                     :when (= val valkey)]
                 [key valval])
         extended-pairset (into pairset trans)]

     (if (= pairset extended-pairset)
       pairset
       (recur (into pairset trans)))))
 #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
    ["spider" "cat"] ["spider" "man"] ["spider" "snake"]})
 ;#{[8 4] [9 3] [4 2] [27 9]})
 ;#{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]})

(testfn rels)

(comment
  (into
    #{[1 2]}
    '([2 3]))
  ({:a 1 \b 2} \b))