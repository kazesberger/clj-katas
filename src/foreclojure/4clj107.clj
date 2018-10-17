(ns foreclojure.4clj107)


(((fn [n]
    (partial #(apply * (take n (repeat %)))))
  2) 16)

(partial apply * (take 3 (repeat 2)))

(fn my-pow [n]
  #(apply * (take n (repeat %))))

(map (my-pow 2) [1 2 3 4 5])

