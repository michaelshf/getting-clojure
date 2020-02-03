(ns getting-clojure.chapter17
  (:require [clojure.string :as str]))


(comment
  Chapter 17 - Threads, Promises and Futures

  Threads are generally pretty risky, but have benefits.
  Here we look at thread syntax-
  (defn do-a-thread
    []
    (println "starting thread")
    (println "ending thread"))

  (def a-thread
    (Thread. do-a-thread))

  (.start a-thread)

  (defn do-a-thread2
    []
    (println "starting thread 2")
    (Thread/sleep 3000)
    (println "ending thread 2"))

  (def a-thread2
    (Thread. do-a-thread2))

  (.start a-thread2)

  Threads allow for order control-
  ; (do-a-first-job)
  ; (do-a-second-job)

  Or, allow for multi tasking-
  (.start a-thread2)
  (.start a-thread)

  However, since we can't know which thread finished before another,
  we're left with uncertainty. If our threads defined something for example.

  This is a race condition.

  It is also pretty easily avoided - by sticking to immutable data structures
  and avoiding putting defs inside of functions.

  Promises further empower threads by maintaining thread consistency.
  They demand a result to an expression and wait until it's given-

  (def the-result (promise))

  (deliver the-result "Michaels")

  This allows for value passing between threads that is safe.

  The Future - a pre-built promise & delivery mechanism.
  
  )
