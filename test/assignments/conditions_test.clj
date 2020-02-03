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
  (testing "should return true for 2"
    (is (= 2 (harishchandra 2))))
  (testing "should return true for []"
    (is (= [] (harishchandra []))))
  (testing "should return false for false"
    (is (= nil (harishchandra false))))
  (testing "should return false for nil"
    (is (= nil (harishchandra nil)))))