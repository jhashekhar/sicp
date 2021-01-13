;; Newton method to finding square root

(ns sqrt-nm
  (:require [clojure.math.numeric-tower :as math]))


(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqr [x]
  (* x x))

(defn good-enough? [guess x]
  (< (math/abs (- (sqr guess) x)) 0.001))

(defn square-iter [guess x]
  (if (good-enough? guess x)
    (float guess)
    (square-iter (improve guess x) x)))


