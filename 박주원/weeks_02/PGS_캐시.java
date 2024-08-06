/**
 * @title  : [1차] 캐시
 * @author : juwoncode
 */

package juwoncode.devcourse.level1;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    public int solution(int size, String[] cities) {
        List<String> caches = new ArrayList<>();
        int answer = 0;

        if (size == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toUpperCase();

            if (caches.contains(city)) {
                caches.add(caches.remove(caches.indexOf(city)));
                answer++;
                continue;
            }

            if (size <= caches.size()) {
                caches.remove(0);
            }

            caches.add(city);
            answer += 5;
        }

        return answer;
    }
}
