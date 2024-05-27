(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(defn many-rolls [amount-rolls n]
  (take amount-rolls (repeat n)))

(describe "score"
  (it "scores gutter ball game"
    (should= 0 (score (many-rolls 20 0))))
  (it "scores all 1's game"
    (should= 20 (score (many-rolls 20 1))))
  (it "scores all spares game"
    (should= 150 (score (many-rolls 21 5))))
  (it "scores perfect game"
    (should= 300 (score (many-rolls 12 10))))
  (it "near perfect game"
    (should= 270 (score (conj (many-rolls 9 10) 0 0 0 ))))
  )
