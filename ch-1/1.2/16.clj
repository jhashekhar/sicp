;; Solution 1.16
;; merge the successive sqauring with linear iteration

(defn square [x]
  (* x x))

(defn reformed-expt-iter [b counter product]
  (cond 
    (= counter 0) product
    (even? counter) (reformed-expt-iter b (int (/ counter 2)) (square product))
    :else (reformed-expt-iter b (- counter 1) (* b product))))

(defn reformed-expt [b n]
  (reformed-expt-iter b n 1))


;; Solution 1.17 and 1.18
;; helper functions
(defn my-double [n]
  (* 2 n))

(defn halve [n]
  (int (/ n 2)))

;; Sol 1.17
(defn fast-mult [a b]
  (cond
    (= b 0) 0
    (even? b) (my-double (fast-mult a (halve b)))
    :else (+ a (fast-mult a (- b 1)))))


;; Sol 1.18
(defn fast-mul-iter [a b product]
  (cond
    (= b 0) product
    (even? b) (fast-mul-iter a (halve b) (my-double product))
    :else (fast-mul-iter a (- b 1) (+ a product))))

(defn fast-mul [a b]
  (fast-mul-iter a b 0))


