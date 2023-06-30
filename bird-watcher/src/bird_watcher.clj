(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds)
  )

(defn inc-bird [birds]
  (assoc birds (- (count birds) 1) (inc (last birds)))
  )

(defn day-without-birds? [birds]
  (if (some #(= 0 %) birds) true false)
  )

(defn n-days-count [birds n]
  (reduce + (subvec birds 0 n))
  )

(defn busy-days [birds]
  (count (filter #(>= % 5) birds))
  )

(defn odd-week? [birds]
  (def r (reduce (fn [a b] (
    if (or (and (= a 0) (= b 1)) (and (= a 1) (= b 0))) b (reduced false)
  )) birds))
  (if (int? r) true false)
  )
