(ns bowling-kata.core)

(defn- spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn- strike? [rolls]
  (= 10 (first rolls)))

(defn- drop-frames [rolls]
  (if (strike? rolls)
    (rest rolls)
    (drop 2 rolls)))

(defn- score-frames [result rolls]
  (let [[roll1 roll2 roll3] rolls]
    (if (or (strike? rolls) (spare? rolls))
      (conj result (+ roll1 roll2 roll3))
      (conj result (+ roll1 roll2)))))

(defn- frames [rolls]
  (loop [iterate 0, rolls rolls, result []]
    (if (= iterate 10)
      result
      (recur (inc iterate) (drop-frames rolls) (score-frames result rolls)))))

(defn score [rolls]
  (reduce + (frames rolls)))