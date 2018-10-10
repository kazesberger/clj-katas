(ns foreclojure.4clj98)

( (defn eq-class [f d]
    (->> d
         (group-by f)
         (vals)
         (map set)
         (set)))

  #(* % %) #{-2 -1 0 1 2})
