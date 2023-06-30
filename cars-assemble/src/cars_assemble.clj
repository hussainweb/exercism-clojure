(ns cars-assemble)

(def cars-per-hour 221)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (def success-rate
    (cond (and (>= speed 1) (<= speed 4)) 1.0
          (and (>= speed 5) (<= speed 8)) 0.9
          (= speed 9) 0.8
          (= speed 10) 0.77
          :else 0.0
      )
    )
  (* (* speed cars-per-hour) success-rate)
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60))
  )
