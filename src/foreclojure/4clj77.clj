(ns foreclojure.4clj77)

(defn testfn [__]
  (and

    (= (__ ["meat" "mat" "team" "mate" "eat"])
       #{#{"meat" "team" "mate"}})
    (= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
       #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})))

(defn samplefn [__]
  [
    (__ ["meat" "mat" "team" "mate" "eat"])
    (__ ["veer" "lake" "item" "kale" "mite" "ever"])])

(def samples
  [
    ["meat" "mat" "team" "mate" "eat"]
    ["veer" "lake" "item" "kale" "mite" "ever"]])


((fn [strings]
   (->> (group-by sort strings)
        (vals)
        (map set)
        (remove #(< (count %) 2))
        (set)))
 (get samples 0))


(samplefn anagrams)

(comment
  (into {} [[:a 1]]))