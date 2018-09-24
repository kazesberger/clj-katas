(ns foreclojure.4clj74)

(defn testfn [__]
  (and
    (= (__ "4,5,6,7,8,9") "4,9")
    (= (__ "15,16,25,36,37") "16,25,36")))

(defn samplefn [__]
  [(__ "4,5,6,7,8,9")
   (__ "15,16,25,36,37")])

(defn filter-perfect-squares [s]
  (let [ints (re-seq #"[^,]+" s)
        highest-int (Integer/parseInt (last ints))
        perfect-squares (map (comp str #(* %1 %1)) (rest (range)))]
     (clojure.string/join \,
       (sort
         (clojure.set/intersection
           (set ints)
           (set (take-while #(>= highest-int (Integer/parseInt %)) perfect-squares)))))))

(read-str)
(Math/floor)

(samplefn filter-perfect-squares)

(take 5
  (map (comp str #(* %1 %1)) (rest (range))))