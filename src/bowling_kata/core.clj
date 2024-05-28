(ns bowling-kata.core)

(defn- spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn- strike? [rolls]
  (= 10 (first rolls)))

(defn- frame-dropper [rolls]
  (if (strike? rolls)
    (rest rolls)
    (drop 2 rolls)))

(defn- frame-scorer [result rolls]
  (if (or (strike? rolls) (spare? rolls))
    (conj result (+ (first rolls) (second rolls) (nth rolls 2)))
    (conj result (+ (first rolls) (second rolls)))))

(defn- frames [rolls]
  (loop [iteration 0
         rolls rolls
         result []]
    (if (= 10 iteration)
      result
      (recur (inc iteration)
             (frame-dropper rolls)
             (frame-scorer result rolls)))))

(defn score [rolls]
  (reduce + (frames rolls)))