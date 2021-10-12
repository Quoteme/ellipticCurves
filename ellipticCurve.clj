(ns ellipticCurve
  (:require [clojure.math.numeric-tower :as math]))

;; Wir wollen in diesem Programm die Grundlagen des Gruppengesetzes
;; welches auf elliptischen Kruven vorhanden sind programmatisch
;; umsetzen.

(defn ellipAdd
  " Given the points p=[x1 y1] and q=[x2 y2] and the elliptic curve
   y^2=x^3+ax^2+bx+c, calculate p+q using the group law on elliptic curves"
  [ [a b c] [x1 y1] [x2 y2]]
  (if (= [x1 y1] [x2 y2])
    ;; Hier müssen wir die Duplikationsformel verwenden!
    (let [x3 (/ (+ (* x1 x1 x1 x1) (- (* 2 b x1 x1)) (- (* 8 c x1)) (* b b) (- (* 4 a c)) )
                (+ (* 4 (* x1 x1 x1)) (* 4 a x1 x1) (* 4 b x1) (* 4 c)))
          f (fn [x] (+ (* x x x) (* a x x) (* b x) c))
          y3 (math/sqrt (f x3))]
      [x3 y3])
    ;; Hier verwenden wir die normale art elemente zu 
    (let [lam (/ (- y2 y1) (- x2 x1))
          nu  (- y1 (* lam x1)) 
          x3 (+ (* lam lam) (- a) (- x1) (- x2) )
          y3 (+ (* lam x3) nu)]
      [x3 (- y3)])))

(ellipAdd [0 0 0] [1 2] [3 4])
(ellipAdd [0 0 0] [1 2] [1 2])
