(ns getting-clojure.chapter2
  (:require [clojure.string :as str]))

; Vectors and Lists
;; Collection based data structures in clojure
(def a-vector [1 2 3 4])

(def can-hold-anything [1 "two" 3 "four"])

(def even-booleans [true 2 "three" 4 ])

(def nested-vectors [[1] [2] [3 4]])

; A toolkit of functions:
(vector true 2 "three" 4) ; build a vector
(vector) ; even if it's empty

(def novels ["Emma" "Coma" "War and Peace"])
(first novels) ; gives the first item in the collection

(rest novels) ; returns a sequence (generic collection) - not vector!
(rest (rest novels)) ; you can nest away, because rest can be called on a seq
(rest (rest (rest novels))) ; all the way to an empty collection

; You could first and rest your way through a collection
(nth novels 2) ; or just use nth

(novels 2) ; or call a vector like a collection - cool!

; More vector manipulation:
(conj novels "Carrie") ; to add to the end
(cons "Carrie" novels) ; to add to the front


; Lists
'(1 2 3) ; mind the apostrophe
'(true "two" 3 4) ; similar to vectors, can hold anything

(def a-list '(1 2 3))
(def poems '("Iliad" "Odyssey" "Now We Are Six"))

; there are many similar functions to vectors
(count poems)
(first poems)
(rest poems)
(nth poems 2)

; So What's the Difference?
; Both are ordered sequential collections

; Lists are implemented as "linked lists" - which give certain benefits
; Probably worth studying this, but:
;; Linked lists are easier to add to front, vectors easier to add to back
;; Outside of efficiencies, know that conj adds wherever most efficient ^


; Staying out of Trouble
;; Remember that conj and cons don't impact the original binding
(def original-vector [1 2 3])
(conj original-vector 4)

original-vector ; still just [1 2 3]

; In The Wild
;; Vectors are often used more than lists
;; Lists are integrally involved with executing clojure code,
;; more in chapter 19 on this.
(println "End of Chapter")
