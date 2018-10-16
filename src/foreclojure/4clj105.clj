(ns foreclojure.4clj105)

(partition-by type [:a 1 2 3 :b :c 4])


( (fn kv-map [coll]
    (let [basemap (into {} (map #(vector % []) (filter keyword? coll)))]
      (->> coll
           (partition-by type)
           (map #(if (keyword? (first %)) (last %) %))
           (partition 2)
           (map vec)
           (into {})
           (merge basemap))))

 [:a 1 2 3 :b :c 4])


(into {} (map #(vector % []) (filter keyword? [:a 1 2 3 :b :c 4])))
