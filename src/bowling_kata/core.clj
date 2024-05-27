(ns bowling-kata.core)

(defn- strike? [rolls]
  (= 10 (+ (first rolls))))

(defn- spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn frame-scorer [result remaining-rolls]
  (let [roll1 (first remaining-rolls)
        roll2 (second remaining-rolls)]
    (if (or (strike? remaining-rolls) (spare? remaining-rolls))
      (conj result (+ roll1 roll2 (nth remaining-rolls 2)))
      (conj result (+ roll1 roll2)))))

(defn- frame-dropper [remaining-rolls]
  (if (strike? remaining-rolls)
    (drop 1 remaining-rolls)
    (drop 2 remaining-rolls)))

(defn- frames [rolls]
  (loop [iteration 0, remaining-rolls rolls, result []]
    (if (= iteration 10)
      result
      (recur (inc iteration)
             (frame-dropper remaining-rolls)
             (frame-scorer result remaining-rolls)))))

(defn score [rolls]
  (reduce + (frames rolls)))