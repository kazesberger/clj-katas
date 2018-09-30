(ns foreclojure.4clj82)

(defn chainable?
  "recursive check for insert/delet/subst. dirty? indicates whether a diff already was found once."
  [s1 s2 dirty?]
  ;(println s1 s2 dirty?)
  (if (and (empty? s1)(empty? s1)) true
    (let [match? (= (first s1) (first s2))
          next-s1 (if (or (<= 0 (- (count s1) (count s2))) match?)
                      (rest s1)
                      s1)
          next-s2 (if (or (<= 0 (- (count s2) (count s1))) match?)
                      (rest s2)
                      s2)]

      (if (or (and dirty? (not= (first s1) (first s2)))
              (> (- (count s1) (count s2)) 1)
              (< (- (count s1) (count s2)) -1))
        false
        (recur next-s1 next-s2 (or dirty? (not match?))))))) ; takes care of dirty+notMatching and notDirty+matching



;((defn grid [words]
;   (for [w words]
;     [w (filter #(chainable? w % false) words)])
;  #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))

((defn build-chain [seq set]
   (if (empty? set))
   (for [word set]
     (cons seq (filter)))
  #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))

((fn wordchain?
   ( [words]
     (wordchain? words nil))
   ( [words prev]
     (letfn
       [(chainable? [s1 s2 dirty?]
          ;(println s1 s2 dirty?)
          (if (and (empty? s1)(empty? s1)) true
            (let [match? (= (first s1) (first s2))
                  next-s1 (if (or (<= 0 (- (count s1) (count s2))) match?)
                            (rest s1)
                            s1)
                  next-s2 (if (or (<= 0 (- (count s2) (count s1))) match?)
                            (rest s2)
                            s2)]

              (if (or (and dirty? (not= (first s1) (first s2)))
                      (> (- (count s1) (count s2)) 1)
                      (< (- (count s1) (count s2)) -1))
                false
                (recur next-s1 next-s2 (or dirty? (not match?)))))))] ; takes care of dirty+notMatching and notDirty+matching

       (if (seq words)
         (boolean
           (some true?
             (for [w words
                   :when (or (nil? prev) (chainable? prev w false))]
              (wordchain? (disj words w) w))))
         true))))
 #{"cat" "coat" "car"})


((fn wordchain-loop?
   "this is an attempt to compare loop and functional approach."
   ( [words]
     (wordchain-loop? words nil))
   ( [words prev]
     (if (seq words)
       (loop [[w & more] (seq words)]

         (if (and (or (nil? prev) (chainable? prev w false))
                  (wordchain-loop? (disj words w) w))

           true
           (if more
             (recur more)
             false)))

       true)))
 #{"cat" "coat" "car"})

;(disj '("asdf" "qwer") "asdf")

(comment
  (filter #(chainable? % false) #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))

(comment
  (chainable? "abcd" "abc" false)

  (next (rest "c"))
  (cond->> [1 1]
           (apply =) "even")
  (case (+ 1 1)
        1 (println "wat")
        3 (println "damn right")
        (println :wat)))