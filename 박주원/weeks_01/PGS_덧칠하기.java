/**
 * @title  : 덧칠하기
 * @author : juwoncode
 */

public class PGS_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int roller = m - 1, range = section[0] + roller, answer = 1;

        for (int i = 1; i < section.length; i++) {
            if (section[i] > range) {
                range = section[i] + roller;
                answer++;
            }
        }

        return answer;
    }
}
