import java.util.ArrayList;

class Solution {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<String>();

        // 캐시 사이즈가 0일 때는 모든 접근이 캐시 미스
        if (cacheSize == 0)
            return cities.length * 5;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase(); // 도시 이름을 대문자로 변환

            if (list.contains(cities[i])) {
                answer++; // 캐시 히트: 1초 소요
                list.remove(cities[i]);
                list.add(cities[i]); // 도시를 리스트의 끝으로 이동
            } else {
                answer += 5; // 캐시 미스: 5초 소요
                if (list.size() == cacheSize) {
                    list.remove(0); // 캐시가 가득 찬 경우 가장 오래된 도시 제거
                }
                list.add(cities[i]); // 새로운 도시 추가
            }
        }
        return answer; // 총 소요 시간 반환
    }
}
