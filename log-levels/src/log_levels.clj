(ns log-levels
  (:require [clojure.string :as str]))

(defn parse-log [s]
  (def m (str/split s #":"))
  (def level (nth m 0))
  (def msg (str/trim (nth m 1)))
  (def level (
    subs level 1 (- (count level) 1)
  ))
  (list level msg)
)

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (def l (parse-log s))
  (nth l 1)
  )

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (def l (parse-log s))
  (str/lower-case (first l))
  )

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (def l (parse-log s))
  (format "%s (%s)" (last l) (str/lower-case (first l)))
  )
