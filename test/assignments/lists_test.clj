(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map'"
    (testing "identity with single vector"
      (is (= [1 2 3 4] (map' identity [1 2 3 4]))))
    (testing "inc with single list"
      (is (= '(2 3 4) (map' inc '(1 2 3)))))
    (testing "first with single list of lists"
      (is (= '(1 4) (map' first '([1 2 3] [4 5 7])))))
    (testing "+ with multiple lists"
      (is (= '(5 7 9) (map' + [1 2 3] [4 5 6])))))

  (testing "filter'"
    (testing "should return [1 3] for (odd? [1 2 3 4])"
      (is (= [1 3] (filter' odd? [1 2 3 4]))))
    (testing "should return [] for (even? [1 3 5 7])"
      (is (= '() (filter' even? '(1 3 5 7))))))

  (testing "reduce'"
    (testing "should return 15 for (+ [1 2 3 4 5])"
      (is (= 15 (reduce' + [1 2 3 4 5]))))
    (testing "should return 10 for (+ -5 [1 2 3 4 5])"
      (is (= 10 (reduce' + -5 '(1 2 3 4 5))))))

  (testing "count'"
    (testing "should return 5 for ([1 2 3 4 5])"
      (is (= 5 (count' [1 2 3 4 5]))))
    (testing "should return 0 for ([1 2 3 4 5])"
      (is (= 0 (count' '()))))))
