(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator returning nil"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator returning :infinite"
    (is (= :infinite (informative-divide 3 0)))))

(deftest raja-harishchandra
  (testing "should return true for true"
    (is (true? (harishchandra true))))
  (testing "should return 2 for 2"
    (is (= 2 (harishchandra 2))))
  (testing "should return [] for []"
    (is (= [] (harishchandra []))))
  (testing "should return nil for false"
    (is (= nil (harishchandra false))))
  (testing "should return nil for nil"
    (is (= nil (harishchandra nil)))))

(deftest yudishtira-bachan
  (testing "should return true for true"
    (is (true? (yudishtira true))))
  (testing "should return 2 for 2"
    (is (= 2 (yudishtira 2))))
  (testing "should return [] for []"
    (is (= [] (yudishtira []))))
  (testing "should return :ashwathama for false"
    (is (= :ashwathama (yudishtira false))))
  (testing "should return :ashwathama for :nil"
    (is (= :ashwathama (yudishtira nil)))))

(deftest first-duplicate
  (testing "should return [1 1 2] for [1 2]"
    (is (= [1 1 2] (duplicate-first [1 2]))))
  (testing "should return nil for []"
    (is (= nil (duplicate-first [])))))

(deftest five.-someone
  (testing "should return :chetan-bhagat for [:x 2, :y 5]"
    (is (= :chetan-bhagat (five-point-someone 2 5))))
  (testing "should return :satan-bhagat for [:x 5, :y 0]"
    (is (= :satan-bhagat (five-point-someone 5 0))))
  (testing "should return :greece for [:x 6, :y 0]"
    (is (= :greece (five-point-someone 6 0))))
  (testing "should return :universe for [:x 2, :y 4]"
    (is (= :universe (five-point-someone 2 4)))))

(deftest apply-conditions
  (testing "should return :wonder-woman for [0 1 2 3]"
    (is (= :wonder-woman (conditions-apply [0 1 3]))))
  (testing "should return :durga for [:a :b :c :d]"
    (is (= :durga (conditions-apply [:a :b :c :d]))))
  (testing "should return :cleopatra for [[2 3] [4 5]]"
    (is (= :cleopatra (conditions-apply [[2 3] [4 5]]))))
  (testing "should return :tuntun for [x 2 y 4]"
    (is (= :tuntun (conditions-apply [:x 2 :y 4]))))
  (testing "should return :tuntun for [0 2 3 1]"
    (is (= :tuntun (conditions-apply [0 2 3 1])))))

(deftest repeat-&-truncate
  (testing "should return [0 1 2 0] for ([0 1 2] true true 4)"
    (is (= [0 1 2 0] (repeat-and-truncate [0 1 2] true true 4))))
  (testing "should return [0 1 2 0 1 2] for ([0 1 2] true false 4"
    (is (= [0 1 2 0 1 2] (repeat-and-truncate [0 1 2] true false 4))))
  (testing "should return [0 1] for ([0 1 2] false true 2"
    (is (= [0 1] (repeat-and-truncate [0 1 2] false true 2))))
  (testing "should return [0 1 2] for ([0 1 2] false false 2"
    (is (= [0 1 2] (repeat-and-truncate [0 1 2] false false 4)))))

(deftest order-in-the-words
  (testing "should return [:x-greater-than-y :y-greater-than-z] for [4 3 2])"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "should return [:x-greater-than-y :z-greater-than-x] for [4 3 5])"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "should return [:z-greater-than-x] for [2 3 4])"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4)))))

(deftest zero-like-aliases
  (testing "should return :zero for 0)"
    (is (= :zero (zero-aliases 0))))
  (testing "should return :empty for [])"
    (is (= :empty (zero-aliases []))))
  (testing "should return :empty for '()"
    (is (= :empty (zero-aliases '()))))
  (testing "should return :empty-set for #{})"
    (is (= :empty-set (zero-aliases #{}))))
  (testing "should return :empty-map for {})"
    (is (= :empty-map (zero-aliases {}))))
  (testing "should return :not-zero for 1)"
    (is (= :not-zero (zero-aliases 1)))))

(deftest zero-palindrome
  (testing "should return (4 3 2 0 2 3 4) for [1 2 3])"
    (is (= '(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3]))))
  (testing "should return (0) for [])"
    (is (= '(0) (zero-separated-palindrome []))))
  (testing "should return (:a 0 :a) for [:a])"
    (is (= '(:a 0 :a) (zero-separated-palindrome [:a])))))
