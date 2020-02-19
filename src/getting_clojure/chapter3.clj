(ns getting-clojure.chapter3
  (:require [clojure.string :as str]))

; Maps Keywords and Sets
;; What if you don't want have a collection that is ordered or sequential?
;; Maps present values coordination with keys. Sets are based on in/exclusion.

(hash-map :title "Oliver Twist"
          "author" "Dickens"
          "published" 1838)
; => makes a new map

(def book {:title "Oliver Twist"
           "author" "Dickens"
           "published" 1838})
; => so does the curly brackets

; Some basic map functionality:
(get book :title)
; => returns "Oliver Twist"

; Keywords
;; Keywords are actually just a data type like strings, numbers, booleans.
;; They're often used as map keys.

(assoc book :page-count 400 :title "War and Peace")
; => changes the title, and adds a page count to book.
;; Recall that maps are still immutable - gotta def a new thing.
(def new-book
  (assoc book :page-count 400 :title "War and Peace"))

; Some other functions:
(keys new-book)
(vals new-book)

; Sets
; reformat to call set on list
(def a-set #{1 2 3})
;; => gives #{1 2 3}
;; Sets are an inclusion/exculsion business, often called "mathematical" sets
(def b-set #{1 1 2})
; maybe conj a duplicative item?
;; => gives #{1 2}

;; Sets do NOT have an order, but do have some add/remove
(conj #{1 2} 3)
;; => returns (maybe) #{1 3 2} or any order
(disj #{1 2 3} 3)
;; => returns (maybe #{1 2} or any order)

; In the Wild
;; Maps are the most common structure used in clojure programming

; Staying out of Trouble
;; Recall that keywords are not strings.
;; Some other notable functions for maps:
(contains? book :title)
(first book) 
;; => a map is still a collection, but it is NOT ordered - first is nonsensical

(println "End of Chapter 3")
