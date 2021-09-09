(defn make-rat [n d] (list n d))
(defn numer [x] (first x))
(defn denom [x] (first (rest x)))


(defn print-rat [x]
  (newline)
  (printf (str (int (numer x))))
  (printf "/")
  (printf (str (int (denom x)))))
