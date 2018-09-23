(ns foreclojure.4clj70)


(defn testfn [__]
  (and
    (= (__  "Have a nice day.")
       ["a" "day" "Have" "nice"])
    (= (__  "Clojure is a fun language!")
       ["a" "Clojure" "fun" "is" "language"])
    (= (__  "Fools fall for foolish follies.")
       ["fall" "follies" "foolish" "Fools" "for"])))

(defn samplefn [__]
    [
     (__  "Have a nice day.")
     (__  "Clojure is a fun language!")
     (__  "Fools fall for foolish follies.")])

(defn ws [s]
  (map second (sort (map (juxt clojure.string/lower-case identity) (clojure.string/split (apply str (remove  #{\! \.} s)) #"\ ")))))

(clojure.string/lower-case "")

(samplefn #(re-seq #"\w+" %))
(testfn ws)