(ns bowling-kata.core-spec
  (:require [speclj.core :refer :all]
            [bowling-kata.core :refer :all]))

(defn many-rolls [times-rolled num]
  (take times-rolled (repeat num)))

(describe "bowling kata"
  (describe "score"
    (it "scores a gutter game"
      (should= 0 (score (many-rolls 20 0))))
    (it "scores an all 1's game"
      (should= 20 (score (many-rolls 20 1))))
    (it "scores an all spares game"
      (should= 150 (score (many-rolls 21 5))))
    (it "scores a perfect game"
      (should= 300 (score (many-rolls 12 10))))))