;; sum of squares of two larger numbers

(defn square [x] (* x x))

(defn sum-of-squares [x y] (+ (square x) (square y)))

(defn solution [a b c]
  (cond
    (and (>= a c) (>= b c)) (sum-of-squares a b)
    (and (>= c b) (>= a b)) (sum-of-squares a c)
    (and (>= c a) (>= b a)) (sum-of-squares b c)
    )
  )


