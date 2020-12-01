(def x [1721 979 366 299 675 1456])

(filter some? (for [x1 x x2 x] (if (= (+ x1 x2) 2020) (* x1 x2))))

(filter some? (for [x1 x x2 x x3 x] (if (= (+ x1 x2 x3) 2020) (* x1 x2 x3) nil)))
