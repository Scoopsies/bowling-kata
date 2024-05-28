(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(describe "Bowling kata"
  (describe "score"
    (it "scores a all gutter game"
      (should= 0 (score (take 20 (repeat 0)))))
    (it "scores all 1's game"
      (should= 20 (score (take 20 (repeat 1)))))
    (it "scores all spares game"
      (should= 150 (score (take 21 (repeat 5)))))
    (it "scores perfect game"
      (should= 300 (score (take 12 (repeat 10)))))
    ))