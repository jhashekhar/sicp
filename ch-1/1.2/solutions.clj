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


;; Sol 1.21
(defn divides? [a b]
  (= (rem b a) 0))

(defn find-divisor [n test-divisor]
  (cond
    (> (square test-divisor) n) n
    (divides? test-divisor n) test-divisor
    :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? 
  [n]
  (= n (smallest-divisor n)))

;; Sol 1.22
(defn search-for-primes [low high n]
 (if (and (< low high) (< n 3)) 
   (cond (prime? low) (do
                        (println low)
                        (recur (+ low 2) high (+ n 1))
                      )
   :else (recur (+ low 2) high n))
))

;; Sol 1.23
(defn nextn [n]
  (if (= n 2) 3 (+ n 2)))

(defn modified-find-divisor [n test-divisor]
  (cond
    (> (square test-divisor) n) n
    (divides? (nextn test-divisor) n) test-divisor
    :else (modified-find-divisor n (+ test-divisor 1))))

(defn modified-smallest-divisor [n]
  (modified-find-divisor n 2))












