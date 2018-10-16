(ns foreclojure.4clj104)


(def r-numerals {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000})
(def r-nums-reversed (zipmap (vals r-numerals) (keys r-numerals)))

(def num 140)

(defn samplefn [__]
  [
   (__ 1)
   (__ 30)
   (__ 4)
   (__ 140)
   (__ 827)
   (__ 3999)
   (__ 48)])

(samplefn (fn [num]
            (let [ordered-map [["M" 1000]
                               ["CM" 900]
                               ["D"  500]
                               ["CD" 400]
                               ["C"  100]
                               ["XC"  90]
                               ["L"   50]
                               ["XL"  40]
                               ["X"   10]
                               ["IX"   9]
                               ["V"    5]
                               ["IV"   4]
                               ["I"    1]]]
              (loop [roman "" remaining num]
                (if (> remaining 0)
                  (let [[k v] (first (filter #(>= remaining (second %)) ordered-map))]
                    (recur (str roman k) (- remaining v)))
                  roman)))))