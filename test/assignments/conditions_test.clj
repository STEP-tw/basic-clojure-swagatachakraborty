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
