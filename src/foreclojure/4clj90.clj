(ns foreclojure.4clj90)

(#(set (for [x %1
             y %2]
         [x y]))
  #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})