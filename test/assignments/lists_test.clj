(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single vector"
      (is (= [1 2 3 4] (map' identity [1 2 3 4]))))
    (testing "inc with single list"
      (is (= '(2 3 4) (map' inc '(1 2 3)))))
    (testing "first with single list of lists"
      (is (= '(1 4) (map' first '([1 2 3] [4 5 7])))))))
