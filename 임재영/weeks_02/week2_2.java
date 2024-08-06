package pgs.java.study;
import java.util.LinkedHashSet;
public class week2_2 {
    public static void main(String[] args) {
        int cache;
        String[] cities;
        cache = 3;
        cities = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(Solution2.solution(cache, cities));
    }
}

class LimitedSizeSet<E> extends LinkedHashSet<E> {
    private final int maxSize;
    int cache = 0;

    public LimitedSizeSet(int maxSize) {
        this.maxSize = maxSize;
    }
    public boolean add(E e) {
        if (contains(e)) {
            remove(e);
            cache += 1;
        } else if (size() >= maxSize && maxSize > 0) {
            E oldestElement = iterator().next();
            remove(oldestElement);
            cache += 5;
        } else {
            cache += 5;
        }
        return super.add(e);
    }
}

class Solution2 {
    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        LimitedSizeSet<String> ls = new LimitedSizeSet<>(cacheSize);
        for (String city : cities) {
            ls.add(city.toLowerCase());
        }
        return ls.cache;
    }
}

