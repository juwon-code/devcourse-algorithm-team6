/**
 * @title  : 멀리 뛰기
 * @author : juwoncode
 */

import java.util.ArrayList;
import java.util.List;

public class PGS_멀리_뛰기 {
    public long solution(int n) {
        List<Long> numbers = new ArrayList<>();

        numbers.add(1L);
        numbers.add(2L);

        for (int i = 2; i <= n; i++) {
            numbers.add(numbers.get(i - 1) + numbers.get(i - 2) % 1234567);
        }

        return numbers.get(n - 1);
    }
}

/*
    1 => (1)                                                                                           => 1
    2 => (1, 1), (2)                                                                                   => 2
    3 => (1, 1, 1), (2, 1), (1, 2)                                                                     => 3
    4 => (1, 1, 1, 1), (2, 1, 1), (1, 2, 1), (1, 1, 2), (2, 2)                                         => 5
    5 => (1, 1, 1, 1, 1), (2, 1, 1, 1), (1, 2, 1, 1), (1, 1, 2, 1), (1, 1, 1, 2), (2, 2, 1), (2, 1, 2) => 7
 */
