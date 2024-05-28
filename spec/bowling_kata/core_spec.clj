(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(describe "bowling kata"
  (describe "score"
    (it "score a gutter game"
      (should= 0 (score (take 20 (repeat 0)))))
    (it "score a 1's game"
      (should= 20 (score (take 20 (repeat 1)))))
    (it "score all spares game"
      (should= 150 (score (take 21 (repeat 5)))))
    (it "scores a perfect game"
      (should= 300 (score (take 12 (repeat 10)))))
    ))