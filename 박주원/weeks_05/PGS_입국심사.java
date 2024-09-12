package juwoncode.devcourse.level3;

import java.util.Arrays;

public class PGS_입국심사 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        // 1) 심사원의 수(길이)와 정답 변수를 선언한다.
        final int TIMES_LENGTH = times.length;
        long answer = 0;

        // 2) 소요 시간 배열을 정렬한다.
        Arrays.sort(times);

        /*
            3) 이분탐색으로 시간을 절반씩 줄여가며 최적값을 찾는다.
                1. 최소시간은 0, 오른쪽은 최대시간 * n을 곱한값으로 초기화한다.
                2. 중앙시간을 찾고 시간내에 심사가능한 인원수의 합계를 구한다.
                3.1. 심사가능한 인원수 <= 인원수일 경우 최대시간과 정답을 갱신한다.
                3.2. 심사가능한 인원수 > 인원수일 경우 최소시간을 갱신한다.
                4. 최소시간이 최대시간보다 커질 경우 종료한다.
         */
        long minTime = 0, maxTime = (long) times[TIMES_LENGTH - 1] * n;
        while (minTime <= maxTime) {
            long midTime = (minTime + maxTime) / 2;
            long sum = Arrays.stream(times).mapToLong(t -> midTime / t).sum();

            if (sum >= n) {
                answer = midTime;
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }

        return answer;
    }
}
