;; Newton method to finding cube root

(ns cube-nm
  (:require [clojure.math.numeric-tower :as math]))


(defn square [y]
  (* y y))

(defn cube [y]
  (* (square y) y))

(defn improve [guess x]
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

(defn good-enough? [guess x]
  (< (math/abs (- (cube guess) x)) 0.001))

(defn cube-iter [guess x]
  (if (good-enough? guess x)
    (float guess)
    (cube-iter (improve guess x) x)))


