(ns getting-clojure.chapter1
  (:require [clojure.string :as str]))

(comment
  The Very Basics
  - lein repl -> starts a read, eval, print, loop
  - Arithmetic
  - - (operator arg1 arg2 ...)          ; applies op to args
  (+ 1 1)
  (* 2 1)
  (- 4 2)
  (quot 4 2)
  (/ 4 2) 
  (* 2.0 4) 

  - Not Variable Assignment, But Close
  - - (def name thing)                  ; binds symbols to values
  (def my-name "Michaels")
  (def math-result (+ 2 2))

  - A Function of your own
  - - (defn func-name [args-here]
        (function body stuff here))     ; the basic structure
  (defn hello-world [name]
    (println "Hello" name "er.. World!"))
  (hello-world "Michaels")

  - In the Wild
  - - lein has app building framework that is common
  - - project-name/src/project-name/core.clj contains Main
  - - - Main is where an app starts executing

  - Staying Out of Trouble
  - - Divide by Zero -> ArithmeticException
  - - Unbound Vars -> CompilerExeception
  - - Messed up Paren Equality -> RuntimeExeption Unmatched Delimiter
  )
