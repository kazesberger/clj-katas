(ns foreclojure.4clj65)

(defn testfn [__]
  (= [:map :set :vector :list] (map __ [{} #{} [] ()])))

; my original solution:

(defn poke [t]
      (cond
        (= (get (conj t [:foo "bar"]) :foo) "bar") :map
        (= (count (conj t 42)) (count (conj (conj t 42) 42))) :set
        ;dont like my checks for vector/list atm...
        (= 43 (last (conj (conj t 42) 43))) :vector
        (= 43 (first (conj (conj t 42) 43))) :list
        :else :unknown-type))

(testfn poke)

;; --------------------------- after looking into other solutions ----------------------------

; omg i love cgrand's solution, it's perfect:
; empty reduces the testcases essentially to the last testcase: (map __ [{} #{} [] ()])
; had similar thought with filter/remove but those always return a sequence.
; TIL: empty :-)

