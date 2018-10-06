(ns foreclojure.4clj89)

;(
;  (defn matching-stones [stones node]
;    (filter #(seq (filter #{node} %)) stones))
; [[1 2] [2 3] [3 4] [4 1]] 1)
;
;(defn remove-one-occurance [coll x]
;  (let [[n m] (split-with (partial not= x) coll)]
;    (concat n (rest m))))
;
;
;(defn win-domino? [stones tuple]
;  (println stones tuple)
;  (if (empty? stones)
;    true
;    (let [matching-stones-left (filter #(seq (filter #{(first tuple)} %)) stones)
;          matching-stones-right (filter #(seq (filter #{(second tuple)} %)) stones)]
;      (if (empty? (concat matching-stones-left matching-stones-right))
;        false
;        (or
;          (some #(win-domino? (remove-one-occurance stones %) (flatten [(first tuple) (remove-one-occurance % (second tuple))])) matching-stones-right)
;          (some #(win-domino? (remove-one-occurance stones %) (flatten [(second tuple) (remove-one-occurance % (first tuple))])) matching-stones-right))))))

((fn [edges]
   (letfn [(remove-one-occurance [coll x]
             (let [[n m] (split-with (partial not= x) coll)]
               (concat n (rest m))))
           (win-domino? [stones tuple]
             (println stones tuple)
             (if (empty? stones)
               true
               (let [matching-stones-left (filter #(seq (filter #{(first tuple)} %)) stones)
                     matching-stones-right (filter #(seq (filter #{(second tuple)} %)) stones)]
                 (if (empty? (concat matching-stones-left matching-stones-right))
                   false
                   (not
                     (nil?
                       (or
                         (some #(win-domino?
                                  (remove-one-occurance stones %)
                                  (flatten [(first tuple) (remove-one-occurance % (second tuple))]))
                               matching-stones-right)
                         (some #(win-domino?
                                  (remove-one-occurance stones %)
                                  (flatten [(second tuple) (remove-one-occurance % (first tuple))]))
                               matching-stones-right))))))))]

     (not (nil? (some #(win-domino? (remove-one-occurance edges %) %) edges)))))
 [[:a :b] [:a :b] [:a :c] [:c :a] [:a :d] [:b :d] [:c :d]])
 ;[[:a :a] [:b :b]])
 ;[[:a :b]])
 ;[[1 2] [2 3] [3 4] [4 1]])

(comment
  (nil? (or nil nil))
  (remove-one-occurance [2 1 2 3 2] 2)
  ( #{2} [1 2 3 2])
  (set [1])
  (vals [1 2]))