(ns foreclojure.4clj73)

(defn samplefn [__]
  [
   (__ [[:e :e :e]
        [:e :e :e]
        [:e :e :e]])
   (__ [[:x :e :o]
        [:x :e :e]
        [:x :e :o]])
   (__ [[:e :x :e]
        [:o :o :o]
        [:x :e :x]])
   (__ [[:x :e :o]
        [:x :x :e]
        [:o :x :o]])
   (__ [[:x :e :e]
        [:o :x :e]
        [:o :e :x]])
   (__ [[:x :e :o]
        [:x :o :e]
        [:o :e :x]])
   (__ [[:x :o :x]
        [:x :o :x]
        [:o :x :o]])])

; options
; 1) test all 8 win possibilities
; 2) for loop checking all win possibilities that this field can be part of

(def win-positions
  [[[0 0] [0 1] [0 2]]
   [[1 0] [1 1] [1 2]]
   [[2 0] [2 1] [2 2]]
   [[0 0] [1 0] [2 0]]
   [[0 1] [1 1] [2 1]]
   [[0 2] [1 2] [2 2]]
   [[0 0] [1 1] [2 2]]
   [[0 2] [1 1] [2 0]]])


(defn game-running [board]
  (let [win-positions
          [[[0 0] [0 1] [0 2]]
           [[1 0] [1 1] [1 2]]
           [[2 0] [2 1] [2 2]]
           [[0 0] [1 0] [2 0]]
           [[0 1] [1 1] [2 1]]
           [[0 2] [1 2] [2 2]]
           [[0 0] [1 1] [2 2]]
           [[0 2] [1 1] [2 0]]]]
    (->(filter #(apply = %)
        (filter #(not-any? #{:e} %)
          (for [row win-positions]
            (map #(get-in board %) row))))
       (first)
       (first))))

(samplefn game-running)

(comment
  (filter)
  (filter #(not-any? #{:e} %) win-candidates)
  ((fn [& foo]
    ;[(first foo) (second foo) (drop 2 foo)]) [:x :x :x]
    (apply str (first foo))) [:x :x :x])

  (= :x :o :x)


  (def win-candidates
    ((fn wip-fn [f]
       (f [[:x :e :x]
           [:x :e :e]
           [:x :e :o]])) game-running))

  (get-in [[:x :o :x]
           [:x :o :x]
           [:o :x :o]] [0 0])

  (samplefn #(get-in % [0 0])))