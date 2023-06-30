(ns leap)

(defn leap-year? [year]
  (and 
    (= (rem year 4) 0)
    (or
      (not= (rem year 100) 0)
      (= (rem year 400) 0)
    )
  )
)
