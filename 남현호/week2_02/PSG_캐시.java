import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) return 5 * cities.length;
        
        LinkedList<String> cacheList = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            if (!cacheList.contains(cities[i].toLowerCase())) {
                if (cacheList.size() >= cacheSize) cacheList.remove(cacheList.get(0));
                cacheList.add(cities[i].toLowerCase());
                answer += 5;
            } else {
                cacheList.remove(cities[i].toLowerCase());
                cacheList.add(cities[i].toLowerCase());
                answer++;
            }
        }
        
        return answer;
    }
}
