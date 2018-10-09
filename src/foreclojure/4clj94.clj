(ns foreclojure.4clj94)

((defn gol [lines]
   (map #(apply str %)
     (let [board (mapv vec lines)]
       (for [y (range (count board))]
         (for [x (range (count (first board)))]
           (let [livecell? (= \# (get-in board [y x]))
                 c (count (filter #{\#}
                                  (for [dx [-1 0 1]
                                        dy [-1 0 1]]
                                    (when-not
                                      (every? zero? [dx dy])
                                      (get-in board [(+ y dy) (+ x dx)])))))]
             (cond
               (and livecell? (< 1 c 4)) \#
               (and (not livecell?) (= c 3)) \#
               :else \space)))))))
 ["      "
  " ##   "
  " ##   "
  "   ## "
  "   ## "
  "      "])
  ;["     "]
  ;"     "
  ;" ### "
  ;"     "
  ;"     "))

(comment
  (if (#{\#} \#) true false)
  (vec "asdf"))