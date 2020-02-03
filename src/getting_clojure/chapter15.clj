(ns getting-clojure.chapter15
  (:require [clojure.string :as str]))

(comment
  Spec is a clojure library used to validate the shapes of data.
  Example-
    (def book {:title "Clojure" :author "olsen" :copies 10})

  We could write a function to validate a bunch of stuff about book-
    (defn book-check-func? [x]
      (and
       (map? x)
       (string? (:author x))
       (string? (:title x))
       (pos-int? (:copies x))))

    (book-check-func? book) ; => true

  But this gets complicated with bigger structures fast.
  Spec solves this problem intuitively. Taking any predicate and an arg.
  There are a few built in predicates such as number? and pos-int?

  (require '[clojure.spec.alpha :as s])
  (s/valid? number? 10) ; => true
  (s/valid? number? "nope") ; => false

  More compoundly-
  (def n-greaterthan-10 (s/and number? #(> % 10)))
  (s/valid? n-greaterthan-10 11) ; => true
  (s/valid? n-greaterthan-10 9) ; => false

  You can even spec collections, using the same preds-
  (s/valid? (s/coll-of string?) '("a" "b")) ; => true
  (s/valid? (s/coll-of string?) '(1 2))     ; => false

  Or maps-
  (def book-spec
    (s/keys :req-un [:book/title]))
  (def titleless-book {:copies 10 :author "me"})
  (s/valid book-spec book) ; => true
  (s/valid? book-spec titleless-book) ; => false

; todo - fix section
  Global specs can be defintions, similar to functions-
  (def book2 {:title "Clojure2" :author "olsen2" :copies 10})
  (s/def
    :getting-clojure/newbookspec
    (s/keys
     :req-un
     [:book/title :book/copies]))
  (println ::newbookspec)
  (s/valid? ::newbookspec book2)

  Figuring out why a spec doesn't match is quite easy-
  (s/def ::title string?)
  (s/def ::copies int?)
  (s/def ::book-explain-example (s/keys :req-un [::title ::copies]))
  (s/valid? ::book-explain-example {:title "clojure3" :copies 2}) ; => true
  (s/explain ::book-explain-example {:title "clojure3" :copies 2}); => Success!

  for example, in these books with floppies-
  (s/valid? ::book-explain-example {:title "clojure3" :FLOPPIES 2}) ; => false
  (s/explain ::book-explain-example {:title "clojure3" :FLOPPIES 2}); => there aren't copies!

  Conform, is like explain, but returns the results instead of printing-
  (s/conform ::book-explain-example {:title "clojure3" :copies 1})
                                        ; returns descriptive results
  (s/conform ::book-explain-example {:title "clojure3" :floppies "weird"})
                                        ; => returns clojure.spec/invalid!


  Spec'ing inside functions is possible-
  (s/def :inventory.core/inventory
    (s/coll-of ::book))

  Using function pre and post conditions-
  (defn find-by-title
    [title inventory]
    {:pre [(s/valid? ::title title)
           (s/valid? ::inventory inventory)]}
    (some #(when (= (:title %) title) %) inventory))
  but this is quite involved, and could be simpler- using fdef-
  (defn find-by-title2
    [title inventory]
    (some #(when (= (:title %) title) %) inventory))
  (s/fdef find-by-title2
    :args (s/cat :title ::title
                 :inventory ::inventory))

  Checking using fdef does add requirements-
  (require '[clojure.spec.test.alpha :as st])
  (st/instrument 'getting-clojure/find-by-title2)

  Most of the time spec based argument checking is only
  done in testing and dev due to performance.

  Spec driven tests, however, are more generally useful-
  (defn book-blurb [book]
    (str "the best selling book " (:title book) " by " (:author book)))
  (s/fdef book-blurb :args (s/cat :book ::book))

  Some things are required-
  (require '[clojure.spec.test.alpha :as stest])

  (s/fdef book-blurb
    :args (s/cat :book ::book)
    :ret (s/and string? (partial re-find #"The best selling")))
  (stest/check 'getting-clojure/book-blurb)
)
