(ns getting-clojure.chapter16
  (:require [clojure.string :as str]))

;; Interop with Java

(comment
  Notes on Java-
  - Organized around objects, which have fields
  - Objects associated with classes, which typically have constructors
    to create, or instantiate, objects
  - Classes contain methods, function-like code bodies
  - Classes utilize inheritence via superclass adoption

  Clojure accesses java via a variety of req's-
  
)
(def authors (clojure.java.io/file "authors.txt"))


(if (.exists authors)
  (println "The file is there")
  (println "The file is not there"))

  (if (.canRead authors)
    (println "we can read it"))
