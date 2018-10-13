(ns foreclojure.4clj102)

( (fn [s]
    (apply str
      (vec
        (map #(apply str %)
           (map #(update-in % [0] (comp  clojure.string/upper-case str))
             (map vec (clojure.string/split s #"-")))))))
  "something")

( (fn [s]
    (let [words (map vec (clojure.string/split s #"-"))]
      (->> (rest words)
           (map #(update-in % [0] (comp  clojure.string/upper-case str)))
           (cons (first words))
           (map #(apply str %))
           (vec)
           (apply str))))


  "something-sldfj")

;; learned from:
#(clojure.string/replace % #"-." (fn [[_ x]] (format "%S" x)))


(comment
  (update (vec "asdf") 1 #((comp clojure.string/upper-case str) %))
  (first (clojure.string/upper-case \s)))