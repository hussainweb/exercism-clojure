(ns difference-of-squares)

(defn sum-of-squares [number]
  (cond (> number 1) (+ (* number number) (sum-of-squares (- number 1)))
        :else 1
  )
)

(defn summation [number]
  (int (/ (* number (+ number 1)) 2))
)

(defn square-of-sum [number]
  (def sq (summation number))
  (* sq sq)
)

(defn difference [number]
  (- (square-of-sum number) (sum-of-squares number))
)
