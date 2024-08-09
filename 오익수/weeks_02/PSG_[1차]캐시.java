import java.util.ArrayList;

class solution {
  public static int solution(int cacheSize, String[] cities) {

    ArrayList<String> cache = new ArrayList<>();

    int answer = 0;
    int cacheHit = 1;
    int cacheMiss = 5;

    for (String city : cities) {
      city = city.toLowerCase();

      if (cache.contains(city)) {
        answer += cacheHit;
        cache.remove(city);
        cache.add(city);
      } else {
        answer += cacheMiss;
        if (cacheSize > 0 && cache.size() >= cacheSize) {
          cache.remove(city);
        }
        if (cacheSize > 0) {
          cache.add(city);
        }
      }
    }
    return answer;
  }
}
