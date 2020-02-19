(ns getting-clojure.chapter4
  (:require [clojure.string :as str]))

; Logic
; if statements
(defn print-greeting [preferred-customer]
  (if preferred-customer
    (println "Welcome to Blotts Books")))

(print-greeting true)
; => prints the message!

; if + else
(defn print-greeting [preferred-customer]
  (if preferred-customer
    (println "Welcome back to Blotts Books")
    (println "Welcome!")))
(print-greeting false)
; => a rather disingenuous greeting...

(defn shipping-charge
  "Applies a 10% charge for non-preferred"
  [preferred-customer order-amount]
  (if preferred-customer
    0.00
    (* order-amount 0.10)))

; On Equality
(= 1 1)
; => obviously true!
(= 2 (+ 1 1))
; => again pretty obviously true
(= "Emma" "Emma")
; => still true
(= 2 2 3)
; => false, thanks to the three

; Is this a that?
;; Clojure has a bunch of conditional helpers
(number? 10)
; => it is!
(string? 10)
; => no, it's a number
(keyword? :asdf)
; => yup
(vector? ["yes" "I" "am"])
; => it's true!
(true? true)
; => even booleans work... very directly-
(true? 2)
; => 2 is "truthy" but not "true"

; On Truthy and Falsy
;; Everything is truthy except nil and false
(if 2 "yes" "no")
; => 2 is "truthy"! so yes
(if nil "yes" "no")
; => nil and false are falsy, so no


; Do and When
;; Do is a command that allows bundling of expressions
(do
  (println "This is three expressions")
  (println "Bundled as one")
  (println 44))
;; => returns 44, and prints those other statements to repl
;; When bundles based on a conditional
(when true
  (println "Just like a do block")
  44)
;; => again, returns 44

; Multiple Conditions
;; Nested if's can be a mess to read, cond saves the day-
(defn shipping-charge [preferred-customer order-amount]
  (cond ))
