(ns foreclojure.4clj88)


(#(clojure.set/difference (clojure.set/union %1 %2) (clojure.set/intersection %1 %2)) #{1 2 3 4 5 6} #{1 3 5 7})