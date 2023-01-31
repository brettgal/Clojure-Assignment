(ns assignment3
  (:gen-class))

;question 1. access vector element, then the hashmap element inside of it. Repeat for number of elements in vector. Multiply price and quantity for each vector element and add all vector elements together for total. 
(defn bill-total [bill]
  (def total1 (* (get (get bill 0) "price") (get (get bill 0) "quantity")))
  (def total2 (* (get (get bill 1) "price") (get (get bill 1) "quantity")))
  (def total3 (* (get (get bill 2) "price") (get (get bill 2) "quantity")))
  (println (+ total1 total2 total3)))

(bill-total (vector (hash-map "name" "water" "price" 1 "quantity" 3) (hash-map "name" "soda" "price" 3 "quantity" 2) (hash-map "name" "hot dog" "price" 2 "quantity" 6)))


;question 2. Use conj to add the vectors together, resulting in one vector of hashmaps
(defn add-to-bill [bill addToBill]
  (println (conj bill (addToBill 0))))

(add-to-bill (vector (hash-map "name" "water" "price" 1 "quantity" 3)) (vector (hash-map "name" "soda" "price" 4 "quantity" 2)))


;question 3. Filter out numbers 1-n that have remainders when dividing
(defn divisors [n]
  (filter (comp zero? (partial rem n)) (range 1 n)))

(divisors 100)


;question 4. Go through each number and see if it is divisble, add them together from vector, subtract that from original number doubled
(defn abundance [n]
  (- (reduce + (vec (filter #(zero? (rem n %)) (range 1 (+ n 1)))))(* 2 n)))

(abundance 12)


;question 5, loop 1-300 and if the number is positive after going through abundance function, print it
(loop [n 1]
  (when (< n 301)
    (if (> (abundance n) 0)
      (print n)
      )
    (recur (+ n 1))))


;question 6, use regex to compare text to a pattern, count number of times it is true
(defn pattern-count [text pattern]
  (count (re-seq pattern text)))

(pattern-count "abaabaaba" #"aba")

