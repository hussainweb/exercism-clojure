(ns robot-name)

(definterface IRobot
  (getName [])
  (setName [name])
)

(deftype Robot [^:volatile-mutable name]
  IRobot
  (getName [_] name)
  (setName [this new-name] (set! name new-name ))
)

(def robot-names (list))

(defn random-name []
  (str (apply str (repeatedly 2 #(rand-nth "ABCDEFGHIJKLMNOPQRSTUVWXYZ"))) (apply str (repeatedly 3 #(rand-nth "0123456789"))))
)

(defn ->Robot []
  (let [robot-name (random-name)]
    ;; (if (some #(= robot-name %) robot-names)
    ;;   (->Robot)
    ;;   (
    ;;     (def robot-names (list* robot-name robot-names))
        (Robot. robot-name)
    ;;   )
    ;; )
  )
)

(defn robot []
  (->Robot)
)

(defn robot-name [robot]
  (.getName robot)
)

(defn reset-name [robot]
  (.setName robot (random-name))
)
